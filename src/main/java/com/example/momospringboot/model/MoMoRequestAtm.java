package com.example.momospringboot.model;

import com.example.momospringboot.constant.Constant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MoMoRequestAtm {

    private final String accessKey = Constant.ACCESS_KEY_PAY_ATM;
    private final String partnerCode = Constant.PARTNER_CODE_ATM;
    private final String partnerName = Constant.PARTNER_NAME_ATM;
    private final String storeId=Constant.STOREID_ATM;
    private final String requestType = Constant.REQUEST_TYPE_ATM;
    private final String ipnUrl = Constant.IPN_URL_ATM;
    private final String redirectUrl = Constant.REDIRECT_URL_ATM;
    @NonNull
    private String orderId;
    @NonNull
    private Long amount;
    @NonNull
    private String orderInfo;
    @NonNull
    private String requestId;

    private final String LANG = Constant.LANG_ATM;

    @NonNull
    private String extraData;
    private String signature;
    @JsonIgnore
    public String getMessageData(){
        return "accessKey="+accessKey+"&amount="+amount+"&extraData="+extraData+"&ipnUrl="+ipnUrl+"&orderId="+orderId+"&orderInfo="+orderInfo+"&partnerCode="+partnerCode+"&redirectUrl="+redirectUrl+"&requestId="+requestId+"&requestType="+requestType;
    }

}
