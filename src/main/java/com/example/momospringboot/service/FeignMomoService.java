package com.example.momospringboot.service;

import com.example.momospringboot.model.MoMoRequestAtm;
import com.example.momospringboot.model.MoMoResponseAtm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "myClient", url = "https://test-payment.momo.vn")
public interface FeignMomoService {
    @PostMapping("/v2/gateway/api/create")
    MoMoResponseAtm createPayment(@RequestBody MoMoRequestAtm paymentRequest);
}