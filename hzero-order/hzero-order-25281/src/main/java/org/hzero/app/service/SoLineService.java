package org.hzero.app.service;

import org.hzero.domain.entity.SoLine;

import java.util.Map;

/**
 * 销售订单行应用服务
 *
 * @author xuejun.zhu@china-hand.com 2019-08-05 11:38:52
 */
public interface SoLineService {
    SoLine querySoLineByHeadIdAndLineNumber(Map<String,Long> params);
}
