package com.example.momospringboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MoMoResponseQR {
    private String requestId;
    private int errorCode;
    private String orderId;
    private String message;
    private String localMessage;
    private String requestType;
    private String payUrl;
    private String signature;
    private String qrCodeUrl;
    private String deeplink;
    private String deeplinkWebInApp;
}
