package com.renfakai.cpcn.policy.impl;


import com.renfakai.cpcn.annotation.CpcnHandlerType;
import com.renfakai.cpcn.dict.CpcnRequestType;
import com.renfakai.cpcn.policy.AbstractCpcnPayService;
import payment.api.tx.gatheringbatch.Tx1610Response;

/**
 * @author renfakai
 * 1610 是批量代收接口，机构系统向支付平台发起批量代收指令， 支付平台实时返回交易受理结果。支付平台受理交易后，会在特定时 间内对交易进行处理，
 * 机构需要通过 1620-批量代收查询或 1630-批 量代收明细查询接口同步交易状态，建议在交易发起半个小时后同步交易状态
 */
@CpcnHandlerType(value = CpcnRequestType.TX_1610_REQUEST, response = Tx1610Response.class)
public class Tx1610RequestPolicy extends AbstractCpcnPayService {
}
