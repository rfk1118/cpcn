package com.renfakai.cpcn.policy;

import com.alibaba.fastjson.JSONObject;
import com.renfakai.cpcn.annotation.CpcnHandlerType;
import com.renfakai.cpcn.conf.Configuration;
import com.renfakai.cpcn.dict.CpcnConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import payment.api.system.TxMessenger;
import payment.api.tx.TxBaseRequest;
import payment.api.tx.TxBaseResponse;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Objects;

/**
 * 请求统一结果
 *
 * @author renfakai
 * @
 * @date 2019/08/18
 */
public abstract class AbstractCpcnPayService implements InitializingBean {


    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 统一处理工具
     *
     * @param request 请求
     * @return 结果
     */
    public TxBaseResponse handler(TxBaseRequest request) {
        TxBaseResponse response = null;
        logger.info("请求中金请求参数为{}", JSONObject.toJSONString(request));
        String[] resp = this.send(request.getRequestMessage(), request.getRequestSignature(), request.getRequestPlainText());

        if (ObjectUtils.isEmpty(resp) || resp.length <= 1) {
            throw new IllegalArgumentException("返回数据不符合格式");
        }
        CpcnHandlerType cpcnHandlerType = AnnotationUtils.findAnnotation(this.getClass(), CpcnHandlerType.class);
        // check
        Assert.notNull(cpcnHandlerType, "HandlerType获取类型为空");
        Class<? extends TxBaseResponse> responseType = cpcnHandlerType.response();
        Assert.notNull(responseType, "responseType获取类型为空");
        try {
            Constructor<? extends TxBaseResponse> constructor = responseType.getConstructor(String.class, String.class);
            response = constructor.newInstance(resp[0], resp[1]);
            logger.info("请求中金返回参数为{}", JSONObject.toJSONString(response));
        } catch (Exception e) {
            logger.error("处理数据出现错误", e);
        }

        Assert.notNull(response, "获取数据为空");
        // Assert.isTrue(Objects.equals("2000", response.getCode()), response.getMessage());
        return response;
    }


    /**
     * 请求中金接口
     *
     * @param requestMessage   请求的信息
     * @param requestSignature 签名信息
     * @param xml              组成的xml
     * @return 结果
     */
    protected String[] send(String requestMessage, String requestSignature, String xml) {

        TxMessenger txMessenger = new TxMessenger();
        String url = getRequestUrl();
        logger.info(String.format("请求中金数据:[%s],xml为:[%s],url:[%s]", requestMessage, xml, url));
        String[] result = null;
        try {
            result = txMessenger.send(requestMessage, requestSignature, url);
        } catch (Exception e) {
            logger.error(String.format("请求中金出现错误,请求数据为%s", xml), e);
        }
        logger.info(String.format("请求中金返回原始数据为:[%s]", Arrays.toString(result)));
        return result;
    }


    protected String getRequestUrl() {
        return Configuration.get(CpcnConstant.CPCN_REQUEST_URL);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        CpcnHandlerType annotation = this.getClass().getAnnotation(CpcnHandlerType.class);
        if (Objects.nonNull(annotation)) {
            PolicyManager.register(annotation.value().getCode(), this);
        }
    }
}
