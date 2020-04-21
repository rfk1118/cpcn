package com.renfakai.cpcn.policy.impl;

import com.renfakai.cpcn.annotation.CpcnHandlerType;
import com.renfakai.cpcn.dict.CpcnRequestType;
import com.renfakai.cpcn.policy.AbstractCpcnPayService;
import payment.api.tx.scanpay.Tx2813Response;

/**
 * 2813请求
 *
 * @author renfakai
 * @since 2019/08/18
 */
@CpcnHandlerType(value = CpcnRequestType.TX_2813_REQUEST, response = Tx2813Response.class)
public class Tx2813RequestPolicy extends AbstractCpcnPayService {
}
