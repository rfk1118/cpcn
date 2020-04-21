package com.renfakai.cpcn.policy.impl;

import com.renfakai.cpcn.annotation.CpcnHandlerType;
import com.renfakai.cpcn.dict.CpcnRequestType;
import com.renfakai.cpcn.policy.AbstractCpcnPayService;
import payment.api.tx.bankcorp.Tx4530Response;

/**
 * 4530请求
 *
 * @author renfakai
 * @since 2019/08/18
 */
@CpcnHandlerType(value = CpcnRequestType.TX_4530_REQUEST, response = Tx4530Response.class)
public class Tx4530RequestPolicy extends AbstractCpcnPayService {
}
