package com.renfakai.cpcn.notice.strategy.impl;

import com.alibaba.fastjson.JSONObject;
import com.renfakai.cpcn.notice.strategy.AbstractCpcnNoticeService;
import lombok.extern.slf4j.Slf4j;
import payment.api.notice.NoticeRequest;

/**
 * 如果通知未获取到处理器则打印日志
 *
 * @author renfakai
 * @date 2019/08/27
 */
@Slf4j
public class NilCpcnNoticeService extends AbstractCpcnNoticeService<Object, Object> {

    @Override
    protected Object exchange(NoticeRequest request) throws Exception {
        return null;
    }

    @Override
    public void handler(NoticeRequest request) {
        log.error(String.format("数据未找到处理器%s", JSONObject.toJSONString(request)));
    }
}
