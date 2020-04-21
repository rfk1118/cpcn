package com.renfakai.cpcn.annotation;

import com.renfakai.cpcn.dict.CpcnRequestType;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import payment.api.tx.TxBaseResponse;

import java.lang.annotation.*;

/**
 * 中金支付管理器
 *
 * @author renfakai
 */
@Component
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CpcnHandlerType {

    @NonNull
    CpcnRequestType value();

    @NonNull
    Class<? extends TxBaseResponse> response();
}
