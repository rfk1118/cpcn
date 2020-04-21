package com.renfakai.cpcn.policy.impl;

import com.renfakai.cpcn.annotation.CpcnHandlerType;
import com.renfakai.cpcn.conf.Configuration;
import com.renfakai.cpcn.dict.CpcnConstant;
import com.renfakai.cpcn.dict.CpcnRequestType;
import com.renfakai.cpcn.policy.AbstractCpcnPayService;
import payment.api.tx.file.Tx2911Response;

/**
 * @author renfakai
 * @since 2019/09/20
 * 2911-电子回单下载交易接口，机构系统可以用该接口从支付平 台获取指定交易的电子回单。
 * 机构系统按照 2911 接口报文结构组装报文，其中主要包括交易 编码、交易类型编码、交易流水号等信息，报文提交至支付平台后，
 * 会收到支付平台的同步响应，当响应码 Code=2000 时，返回有 PDF 或者 ZIP 格式的文件。
 */
@CpcnHandlerType(value = CpcnRequestType.TX_2911_REQUEST, response = Tx2911Response.class)
public class Tx2911RequestPolicy extends AbstractCpcnPayService {

    @Override
    protected String getRequestUrl() {
        return Configuration.get(CpcnConstant.CPCN_REQUEST_FILE_URL);
    }

}
