package com.renfakai.cpcn.notice.service;

import com.renfakai.cpcn.dto.CpcnNoticeRequest;

public interface CpcnNoticeService {

    /**
     * 处理中金回调
     *
     * @param request 请求
     */
    void handlerNotice(CpcnNoticeRequest request);
}
