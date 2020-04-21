package com.renfakai.cpcn.policy.impl;

import com.renfakai.cpcn.annotation.CpcnHandlerType;
import com.renfakai.cpcn.dict.CpcnRequestType;
import com.renfakai.cpcn.policy.AbstractCpcnPayService;
import payment.api.tx.bankcorp.Tx4532Response;
/**
 * 4532请求
 *
 * @author renfakai
 * @since 2019/08/18
 */
@CpcnHandlerType(value = CpcnRequestType.TX_4532_REQUEST, response = Tx4532Response.class)
public class Tx4532RequestPolicy extends AbstractCpcnPayService {
}
