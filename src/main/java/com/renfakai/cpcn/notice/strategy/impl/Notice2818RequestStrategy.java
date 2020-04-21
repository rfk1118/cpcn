package com.renfakai.cpcn.notice.strategy.impl;

import com.renfakai.cpcn.annotation.CpcnNoticeHandlerType;
import com.renfakai.cpcn.dict.CpcnNoticeType;
import com.renfakai.cpcn.notice.strategy.AbstractCpcnNoticeService;
import payment.api.notice.Notice2818Request;
import payment.api.notice.NoticeRequest;

/**
 * 2818-支付结果通知
 *
 * @author renfakai
 */
@CpcnNoticeHandlerType(value = CpcnNoticeType.TX_2818_NOTICE)
public class Notice2818RequestStrategy extends AbstractCpcnNoticeService<Notice2818Request, String> {


    @Override
    protected Notice2818Request exchange(NoticeRequest request) throws Exception {
        return new Notice2818Request(request.getDocument());
    }

    @Override
    public void handler(NoticeRequest request) {
        try {
            Notice2818Request notice2818Request = exchange(request);

            // handler 2818 policy
            System.out.println(notice2818Request);
        } catch (Exception e) {
            logger.error("中金扫码支付接收通知出现错误", e);
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

}
