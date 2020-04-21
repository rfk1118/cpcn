package com.renfakai.cpcn.policy.impl;

import com.renfakai.cpcn.annotation.CpcnHandlerType;
import com.renfakai.cpcn.dict.CpcnRequestType;
import com.renfakai.cpcn.policy.AbstractCpcnPayService;
import payment.api.tx.gatheringbatch.Tx1620Response;

/**
 * @author renfakai
 * 机构系统通过该接口可以对 1610-批量代收交易进行查询，支付 平台返回批量代收交易的交易总金额、总笔数、
 * 以及批次中的每条明 细交易的状态、金额、银行 ID、账户类型、账户名称以及账户号码、 银行响应内容等信息。
 */
@CpcnHandlerType(value = CpcnRequestType.TX_1620_REQUEST, response = Tx1620Response.class)
public class Tx1620RequestPolicy extends AbstractCpcnPayService {
}
