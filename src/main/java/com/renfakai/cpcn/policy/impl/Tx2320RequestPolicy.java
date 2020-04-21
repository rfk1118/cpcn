package com.renfakai.cpcn.policy.impl;

import com.renfakai.cpcn.annotation.CpcnHandlerType;
import com.renfakai.cpcn.dict.CpcnRequestType;
import com.renfakai.cpcn.policy.AbstractCpcnPayService;
import payment.api.tx.accountvalidation.Tx2320Response;

/**
 * 该接口用于验证身份信息，机构系统上送 2320 报文到支付平台。 请求报文中包含机构号、
 * 姓名、身份证号等必传信息，支付平台返回 交易状态等信息。
 *
 * @author refakai
 * @date 2020/03/12
 */
@CpcnHandlerType(value = CpcnRequestType.TX_2320_REQUEST, response = Tx2320Response.class)
public class Tx2320RequestPolicy extends AbstractCpcnPayService {
}

