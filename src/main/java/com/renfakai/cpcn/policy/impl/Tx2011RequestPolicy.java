package com.renfakai.cpcn.policy.impl;

import com.renfakai.cpcn.annotation.CpcnHandlerType;
import com.renfakai.cpcn.dict.CpcnRequestType;
import com.renfakai.cpcn.policy.AbstractCpcnPayService;
import payment.api.tx.realgathering.Tx2011Response;

/**
 * @author renfakai
 * @since 2019/09/20
 * 2011 是单笔代扣接口，机构系统向支付平台发起单笔代扣请求,支付平台将代扣请求同步发送到银行，并将银行处理结果实时返回给机构系统。
 */
@CpcnHandlerType(value = CpcnRequestType.TX_2011_REQUEST, response = Tx2011Response.class)
public class Tx2011RequestPolicy extends AbstractCpcnPayService {
}
