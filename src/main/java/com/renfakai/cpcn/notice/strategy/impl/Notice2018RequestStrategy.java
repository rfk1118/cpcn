package com.renfakai.cpcn.notice.strategy.impl;

import com.renfakai.cpcn.annotation.CpcnNoticeHandlerType;
import com.renfakai.cpcn.dict.CpcnNoticeType;
import com.renfakai.cpcn.notice.strategy.AbstractCpcnNoticeService;
import payment.api.notice.Notice2018Request;
import payment.api.notice.NoticeRequest;

/**
 * 2018-单笔实时扣款结果
 *
 * @author renfakai
 * @date 2019/09/25
 */
@CpcnNoticeHandlerType(value = CpcnNoticeType.TX_2018_NOTICE)
public class Notice2018RequestStrategy extends AbstractCpcnNoticeService<Notice2018Request, String> {


    @Override
    protected Notice2018Request exchange(NoticeRequest request) throws Exception {
        return new Notice2018Request(request.getDocument());
    }

    @Override
    public void handler(NoticeRequest request) {
        try {
            Notice2018Request notice2018Request = exchange(request);

            // handler 2018 policy
            System.out.println(notice2018Request);
        } catch (Exception e) {
            logger.error("中金单笔实时接收通知出现错误", e);
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }
}
