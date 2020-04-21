package com.renfakai.cpcn.policy.impl;

import com.renfakai.cpcn.annotation.CpcnHandlerType;
import com.renfakai.cpcn.dict.CpcnRequestType;
import com.renfakai.cpcn.policy.AbstractCpcnPayService;
import payment.api.tx.paymentbinding.Tx2532Response;

/**
 * @author renfakai
 * @date 2019/09/11
 * 2532 是建立绑定关系(验证并绑定)接口，用户收到建立绑定 关系短信验证码后，系统系统通过该接口将短信验证码提交到支付平 台进行验证，支付平台收到 2532 请求后会立即进行处理，并将建立 绑定关系的结果实时返回给机构系统。
 * 机构系统发送 2532 验证绑卡请求到支付平台进行银行卡绑定， 接口请求中包含机构号、绑定流水号、短信验证码等必填信息。
 * 字段说明:
 * IssueBankID:实际发卡银行，支付平台通过卡 bin 信息获取到用 户银行卡的实际发卡行，并在响应信息里返回给机构系统，机构系统 可以通过该字段的值更新用户的账户信息。
 * IssueCardType:实际卡类型，支付平台通过卡 bin 信息获取到用 户银行卡的实际卡类型，并在响应信息里返回给机构系统，机构系统 可以通过该字段的值更新用户的账户信息
 */
@CpcnHandlerType(value = CpcnRequestType.TX_2532_REQUEST, response = Tx2532Response.class)
public class Tx2532RequestPolicy extends AbstractCpcnPayService {
}
