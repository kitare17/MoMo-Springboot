package com.example.momospringboot.service.imp;

import com.example.momospringboot.model.MoMoRequestAtm;
import com.example.momospringboot.model.MoMoRequestQR;
import com.example.momospringboot.model.MoMoResponseAtm;
import com.example.momospringboot.model.MoMoResponseQR;
import com.example.momospringboot.service.FeignMomoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FeignMomoServiceImp {
    private final FeignMomoService myFeignClient;
    public MoMoResponseAtm createPaymentATM(MoMoRequestAtm paymentRequest) {
        return myFeignClient.createPaymentATM(paymentRequest);
    }
    public MoMoResponseQR createPaymentQR(MoMoRequestQR paymentRequest) {
        return myFeignClient.createPaymentQR(paymentRequest);
    }

}
