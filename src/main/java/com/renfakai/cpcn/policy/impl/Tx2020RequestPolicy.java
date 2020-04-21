package com.renfakai.cpcn.policy.impl;

import com.renfakai.cpcn.annotation.CpcnHandlerType;
import com.renfakai.cpcn.dict.CpcnRequestType;
import com.renfakai.cpcn.policy.AbstractCpcnPayService;
import payment.api.tx.realgathering.Tx2020Response;

/**
 * @author renfakai
 * @date 2020/01/09
 * 机构系统通过该接口可以对 2011-单笔代扣交易进行查询，支 付平台返回该笔代扣交易的金额、交易状态、银行处理时间、结 算标识等信息。
 */
@CpcnHandlerType(value = CpcnRequestType.TX_2020_REQUEST, response = Tx2020Response.class)
public class Tx2020RequestPolicy extends AbstractCpcnPayService {
}
