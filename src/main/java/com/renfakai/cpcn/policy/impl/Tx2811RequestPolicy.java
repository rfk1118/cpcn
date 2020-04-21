package com.renfakai.cpcn.policy.impl;

import com.renfakai.cpcn.annotation.CpcnHandlerType;
import com.renfakai.cpcn.dict.CpcnRequestType;
import com.renfakai.cpcn.policy.AbstractCpcnPayService;
import payment.api.tx.scanpay.Tx2811Response;

/**
 * 2811请求
 *
 * @author renfakai
 * @since 2019/08/18
 */
@CpcnHandlerType(value = CpcnRequestType.TX_2811_REQUEST, response = Tx2811Response.class)
public class Tx2811RequestPolicy extends AbstractCpcnPayService {
}
