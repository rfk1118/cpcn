package com.renfakai.cpcn.replace.base;

import com.renfakai.cpcn.replace.context.CpcnSignatureFactoryContext;
import com.renfakai.cpcn.replace.context.MerchantContext;
import cpcn.institution.tools.util.Base64;
import cpcn.institution.tools.util.StringUtil;
import cpcn.institution.tools.util.XmlUtil;
import org.w3c.dom.Document;

import java.nio.charset.StandardCharsets;

/**
 * 替换TxBaseRequest
 *
 * @author renfakai
 */
public abstract class TxBaseRequestRedefine {

    protected String txCode;
    protected String requestPlainText;
    protected String requestMessage;
    protected String requestSignature;

    public TxBaseRequestRedefine() {
    }

    public String getRequestPlainText() {
        return this.requestPlainText;
    }

    public String getRequestMessage() {
        return this.requestMessage;
    }

    public String getRequestSignature() {
        return this.requestSignature;
    }

    public abstract void process() throws Exception;

    protected void postProcess(Document document) throws Exception {
        this.requestPlainText = XmlUtil.createPrettyFormat(document).trim();
        byte[] data = this.requestPlainText.getBytes(StandardCharsets.UTF_8);
        this.requestMessage = new String(Base64.encode(data));
        byte[] signature = CpcnSignatureFactoryContext.getSignatureFactoryReplace(MerchantContext.get()).getSigner().sign(data);
        this.requestSignature = StringUtil.bytes2hex(signature);
    }
}
