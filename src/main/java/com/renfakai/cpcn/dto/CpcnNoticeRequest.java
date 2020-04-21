package com.renfakai.cpcn.dto;

import lombok.Data;

/**
 * 中金回调参数
 *
 * @author renfakai
 * @date 2019/08/21
 */
@Data
public class CpcnNoticeRequest {

    /**
     * 原始信息
     */
    private String message;

    /**
     * 签名信息
     */
    private String signature;
}
