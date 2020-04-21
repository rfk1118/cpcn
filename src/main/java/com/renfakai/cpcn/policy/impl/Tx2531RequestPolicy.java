package com.renfakai.cpcn.policy.impl;

import com.renfakai.cpcn.annotation.CpcnHandlerType;
import com.renfakai.cpcn.dict.CpcnRequestType;
import com.renfakai.cpcn.policy.AbstractCpcnPayService;
import payment.api.tx.paymentbinding.Tx2531Response;

/**
 * @author renfakai
 * @date 2019/09/11
 * 2531 是建立绑定关系(发送验证短信)接口，该接口用于获取 银行卡建立绑定关系的短信验证码。
 * 机构系统向支付平台发起 2531 指令，支付平台立即进行处理，并将处理结果实时返回给机构系统。
 * 如果建立绑定关系请求受理成功，用户的手机会收到建立绑定关系的 短信验证码，机构系统需要通过 2532 接口将短信验证提交到支付平 台进行验证。
 * 机构系统发送 2531 快捷绑卡请求到支付平台进行银行卡绑定， 接口请求中包含机构号、绑定流水号、银行 ID、账户名称、账户号码、 证件类型、证件号码、手机号、卡类型等必填信息。
 */
@CpcnHandlerType(value = CpcnRequestType.TX_2531_REQUEST, response = Tx2531Response.class)
public class Tx2531RequestPolicy extends AbstractCpcnPayService {
}
