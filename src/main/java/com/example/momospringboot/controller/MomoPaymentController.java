package com.example.momospringboot.controller;

import com.example.momospringboot.constant.Constant;
import com.example.momospringboot.constant.EncryptCustom;
import com.example.momospringboot.model.MoMoRequestAtm;
import com.example.momospringboot.model.MoMoRequestQR;
import com.example.momospringboot.model.MoMoResponseAtm;
import com.example.momospringboot.model.MoMoResponseQR;
import com.example.momospringboot.service.imp.FeignMomoServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("api/v1/payment/momo")
@AllArgsConstructor
public class MomoPaymentController {

    private FeignMomoServiceImp feignMomoService;

    @PostMapping("/atm")
    public ResponseEntity<MoMoResponseAtm> payWithAtm(@RequestBody MoMoRequestAtm paymentRequest)
            throws NoSuchAlgorithmException, InvalidKeyException {
        MoMoRequestAtm momoRequestAtm = paymentRequest;

        //encrypt data to signature
        String secret = Constant.SECRET_KEY_ATM;
        String message = momoRequestAtm.getMessageData();
        String signature= EncryptCustom.encryptSHA256HEX(secret,message);
        momoRequestAtm.setSignature(signature);
        MoMoResponseAtm momoResponseAtm = feignMomoService.createPaymentATM(momoRequestAtm);

        return ResponseEntity.ok(momoResponseAtm);
    }

    @PostMapping("/qr")
//    ResponseEntity<MoMoResponseAtm>
    public ResponseEntity<MoMoResponseQR> payWithQR(@RequestBody MoMoRequestQR paymentRequest)
            throws NoSuchAlgorithmException, InvalidKeyException {
        MoMoRequestQR momoRequestQR = paymentRequest;
        String secret = Constant.SECRET_KEY_QR;
        String message = momoRequestQR.getMessageData();
        String signature= EncryptCustom.encryptSHA256HEX(secret,message);
        momoRequestQR.setSignature(signature);
        MoMoResponseQR moMoResponseQR = feignMomoService.createPaymentQR(momoRequestQR);
        return ResponseEntity.ok(moMoResponseQR);

    }
}
