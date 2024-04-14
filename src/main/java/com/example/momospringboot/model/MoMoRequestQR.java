package com.example.momospringboot.model;

import com.example.momospringboot.constant.Constant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MoMoRequestQR {
    private final String accessKey= Constant.ACCESS_KEY_PAY_QR;
    private final String partnerCode=Constant.PARTNER_CODE_QR;
    private final String requestType=Constant.REQUEST_TYPE_QR;
    private final String notifyUrl=Constant.NOTIFY_URL_QR;
    private final String returnUrl=Constant.RETURN_URL_QR;
    @NonNull
    private String orderId;
    @NonNull
    private String amount;
    @NonNull
    private String orderInfo;
    @NonNull
    private String requestId;
    private String extraData;
    private String signature;
    @JsonIgnore
    public String getMessageData(){
        return "partnerCode="+partnerCode+"&accessKey="+accessKey+"&requestId="+requestId+"&amount="+amount+"&orderId="+orderId+"&orderInfo="+orderInfo+"&returnUrl="+returnUrl+"&notifyUrl="+notifyUrl+"&extraData="+(extraData==null?"":extraData);
    }
}
