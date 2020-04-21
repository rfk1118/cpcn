package com.renfakai.cpcn.policy.impl;

import com.renfakai.cpcn.annotation.CpcnHandlerType;
import com.renfakai.cpcn.dict.CpcnRequestType;
import com.renfakai.cpcn.policy.AbstractCpcnPayService;
import payment.api.tx.scanpay.Tx2814Response;

/**
 * 2813请求
 *
 * @author renfakai
 * @since 2019/08/18
 */
@CpcnHandlerType(value = CpcnRequestType.TX_2814_REQUEST, response = Tx2814Response.class)
public class Tx2814RequestPolicy extends AbstractCpcnPayService {
}
