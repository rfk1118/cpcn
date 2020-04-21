package com.renfakai.cpcn.policy.impl;

import com.renfakai.cpcn.annotation.CpcnHandlerType;
import com.renfakai.cpcn.dict.CpcnRequestType;
import com.renfakai.cpcn.policy.AbstractCpcnPayService;
import payment.api.tx.accountvalidation.Tx2340Response;

/**
 * @author renfakai
 * @since 2019/09/20
 * 该接口用于验证四要素信息(账户名称、账户号码、证件号码、 手机号码)，机构系统上送 2340 报文到支付平台。
 * 请求报文中包含 机构号、账户名称、账户号码、证件类型、证件号码、手机号等必传 信息，支付平台返回交易状态、响应时间等信息。
 */
@CpcnHandlerType(value = CpcnRequestType.TX_2340_REQUEST, response = Tx2340Response.class)
public class Tx2340RequestPolicy extends AbstractCpcnPayService {
}
