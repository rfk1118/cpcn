package com.renfakai.cpcn.dict;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CpcnNoticeType {

    /**
     * 2818-支付结果通知
     */
    TX_2818_NOTICE("2818"),

    /**
     * 2018单笔实时
     */
    TX_2018_NOTICE("2018"),

    ;

    private final String code;
}
