package com.renfakai.cpcn.annotation;

import com.renfakai.cpcn.dict.CpcnNoticeType;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Component
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CpcnNoticeHandlerType {

    @NonNull
    CpcnNoticeType value();
}
