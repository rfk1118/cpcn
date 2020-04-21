package com.renfakai.cpcn.policy.impl;

import com.renfakai.cpcn.annotation.CpcnHandlerType;
import com.renfakai.cpcn.dict.CpcnRequestType;
import com.renfakai.cpcn.policy.AbstractCpcnPayService;
import payment.api.tx.bankcorp.Tx4510Response;

@CpcnHandlerType(value = CpcnRequestType.TX_4510_REQUEST, response = Tx4510Response.class)
public class Tx4510RequestPolicy extends AbstractCpcnPayService {
}
