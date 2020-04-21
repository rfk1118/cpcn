package com.renfakai.cpcn.notice.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import payment.api.notice.NoticeRequest;

public abstract class AbstractCpcnNoticeService<T, R> {


    protected final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 将统一参数转换成特定类型
     *
     * @param request 统一请求
     * @return 结果
     * @throws Exception 转换异常
     */
    protected abstract T exchange(NoticeRequest request) throws Exception;

    /**
     * 统一处理工具
     *
     * @param request 请求
     */
    public abstract void handler(NoticeRequest request);

    /**
     * 校验数据
     *
     * @param r 状态
     * @return 数据
     */
    protected boolean validate(R r) {
        return true;
    }
}
