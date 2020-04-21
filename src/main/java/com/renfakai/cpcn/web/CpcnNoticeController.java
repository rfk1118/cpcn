package com.renfakai.cpcn.web;

import com.renfakai.cpcn.dto.CpcnNoticeRequest;
import com.renfakai.cpcn.notice.service.CpcnNoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import payment.api.notice.NoticeResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * 中金回调我司
 *
 * @author renfakai
 * @date 2019/08/21
 */
@Slf4j
@RestController
@RequestMapping(path = "/cpcn/notice")
public class CpcnNoticeController {

    @Autowired
    private CpcnNoticeService cpcnNoticeService;

    @RequestMapping(value = "/common", method = RequestMethod.POST)
    public NoticeResponse common(HttpServletRequest request) {
        try {
            CpcnNoticeRequest data = new CpcnNoticeRequest();
            data.setMessage(request.getParameter("message"));
            data.setSignature(request.getParameter("signature"));
            cpcnNoticeService.handlerNotice(data);
        } catch (Exception e) {
            log.error("处理中金回调出现错误", e);
            return null;
        }
        return new NoticeResponse();
    }
}
