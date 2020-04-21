package com.renfakai.cpcn.notice;


import com.renfakai.cpcn.annotation.CpcnNoticeHandlerType;
import com.renfakai.cpcn.notice.strategy.AbstractCpcnNoticeService;
import com.renfakai.cpcn.notice.strategy.impl.NilCpcnNoticeService;
import com.renfakai.cpcn.notice.wrap.CpcnNoticeWrapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * 中金回调责任链
 *
 * @author renfakai
 * @date 2019/08/21
 */
@Component
public class CpcnNoticeManager implements BeanPostProcessor {
    /**
     * 策略容器
     */
    private static final List<CpcnNoticeWrapper> WRAPPER_LIST = new ArrayList<>();


    public AbstractCpcnNoticeService getHandler(String code) {
        Optional<CpcnNoticeWrapper> optional = WRAPPER_LIST.stream().filter(item -> Objects.equals(item.getCode(), code)).findFirst();
        return optional.map(CpcnNoticeWrapper::getService).orElse(new NilCpcnNoticeService());
    }

    @Override
    public Object postProcessAfterInitialization(@NonNull Object bean, String beanName) throws BeansException {
        CpcnNoticeHandlerType cpcnNoticeHandlerType = AnnotationUtils.findAnnotation(bean.getClass(), CpcnNoticeHandlerType.class);
        if (Objects.nonNull(cpcnNoticeHandlerType)) {
            CpcnNoticeWrapper cpcnNoticeWrapper = new CpcnNoticeWrapper();
            cpcnNoticeWrapper.setService((AbstractCpcnNoticeService) bean);
            cpcnNoticeWrapper.setCode(cpcnNoticeHandlerType.value().getCode());
            WRAPPER_LIST.add(cpcnNoticeWrapper);
        }
        return bean;
    }
}
