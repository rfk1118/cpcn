package com.renfakai.cpcn.notice.service.impl;

import com.renfakai.cpcn.dto.CpcnNoticeRequest;
import com.renfakai.cpcn.notice.CpcnNoticeManager;
import com.renfakai.cpcn.notice.service.CpcnNoticeService;
import com.renfakai.cpcn.notice.strategy.AbstractCpcnNoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import payment.api.notice.NoticeRequest;

/**
 * 处理中金回调参数
 *
 * @author renfakai
 * @date 2019/08/21
 */
@Slf4j
@Service
public class CpcnNoticeServiceImpl implements CpcnNoticeService {

    @Autowired
    private CpcnNoticeManager cpcnNoticeManager;

    @Override
    public void handlerNotice(CpcnNoticeRequest request) {
        try {
            NoticeRequest noticeRequest = new NoticeRequest(request.getMessage(), request.getSignature());
            AbstractCpcnNoticeService service = cpcnNoticeManager.getHandler(noticeRequest.getTxCode());
            Assert.notNull(service, String.format("获取中金回调处理器为空:[%s]", noticeRequest.getTxCode()));
            service.handler(noticeRequest);
        } catch (Exception e) {
            log.error("处理中金回调数据出现错误", e);
            throw new IllegalArgumentException(e.getLocalizedMessage());
        }
    }
}
