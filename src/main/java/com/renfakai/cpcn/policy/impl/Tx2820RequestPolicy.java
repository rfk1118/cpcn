package com.renfakai.cpcn.policy.impl;

import com.renfakai.cpcn.annotation.CpcnHandlerType;
import com.renfakai.cpcn.dict.CpcnRequestType;
import com.renfakai.cpcn.policy.AbstractCpcnPayService;
import payment.api.tx.scanpay.Tx2820Response;

/**
 * 2820请求
 *
 * @author renfakai
 * @since 2019/08/18
 */
@CpcnHandlerType(value = CpcnRequestType.TX_2820_REQUEST, response = Tx2820Response.class)
public class Tx2820RequestPolicy extends AbstractCpcnPayService {
}
