package com.renfakai.cpcn.notice.wrap;

import com.renfakai.cpcn.notice.strategy.AbstractCpcnNoticeService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 对bean进行包装
 *
 * @author renfakai
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CpcnNoticeWrapper {

    /**
     * 中金的code
     */
    private String code;

    /**
     * 中金的处理器
     */
    private AbstractCpcnNoticeService service;
}
