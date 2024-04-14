package com.example.momospringboot.service;

import com.example.momospringboot.model.MoMoRequestAtm;
import com.example.momospringboot.model.MoMoRequestQR;
import com.example.momospringboot.model.MoMoResponseAtm;
import com.example.momospringboot.model.MoMoResponseQR;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "myClient", url = "https://test-payment.momo.vn")
public interface FeignMomoService {
    @PostMapping("/v2/gateway/api/create")
    MoMoResponseAtm createPaymentATM(@RequestBody MoMoRequestAtm paymentRequest);
    @PostMapping("/gw_payment/transactionProcessor")
    MoMoResponseQR createPaymentQR(@RequestBody MoMoRequestQR paymentRequest);
}