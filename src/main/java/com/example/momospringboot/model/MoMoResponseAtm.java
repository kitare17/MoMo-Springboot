package com.example.momospringboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MoMoResponseAtm {
    private String partnerCode;
    private String orderId;
    private String requestId;
    private int amount;
    private long responseTime;
    private String message;
    private int resultCode;
    private String payUrl;
    private String signature;
}
