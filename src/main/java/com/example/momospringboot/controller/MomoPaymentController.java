package com.example.momospringboot.controller;

import com.example.momospringboot.constant.Constant;
import com.example.momospringboot.model.MoMoRequestAtm;
import com.example.momospringboot.model.MoMoResponseAtm;
import com.example.momospringboot.service.imp.FeignMomoServiceImp;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("api/v1/payment/momo")
@AllArgsConstructor
public class MomoPaymentController {

   private FeignMomoServiceImp  feignMomoService;

    @PostMapping("/atm")
    public ResponseEntity<MoMoResponseAtm> payWithAtm(
            @RequestBody MoMoRequestAtm paymentRequest
    ) throws NoSuchAlgorithmException, InvalidKeyException {
        MoMoRequestAtm momoRequestAtm = paymentRequest;

        //encrypt data to signature
        String secret = Constant.SECRET_KEY_ATM;
        String message = momoRequestAtm.getMessageData();
        System.out.println(message);
        Mac sha256Hmac = Mac.getInstance("HmacSHA256");

        SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        sha256Hmac.init(secretKey);

        byte[] hashedBytes = sha256Hmac.doFinal(message.getBytes(StandardCharsets.UTF_8));

        StringBuilder signature = new StringBuilder();
        for (byte b : hashedBytes) {
            signature.append(String.format("%02x", b));
        }
        momoRequestAtm.setSignature(signature.toString());
        MoMoResponseAtm momoResponseAtm= feignMomoService.createPayment(momoRequestAtm);

        return ResponseEntity.ok(momoResponseAtm);
    }

}
