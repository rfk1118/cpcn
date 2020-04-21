package com.renfakai.cpcn.policy.impl;

import com.renfakai.cpcn.annotation.CpcnHandlerType;
import com.renfakai.cpcn.dict.CpcnRequestType;
import com.renfakai.cpcn.policy.AbstractCpcnPayService;
import payment.api.tx.scanpay.Tx2841Response;

/**
 * 2841 二维码订单关闭
 *
 * @author renfakai
 * @since 2019/08/18
 */
@CpcnHandlerType(value = CpcnRequestType.TX_2841_REQUEST, response = Tx2841Response.class)
public class Tx2841RequestPolicy extends AbstractCpcnPayService {
}
