package org.hzero.app.service;

import org.hzero.domain.entity.SoHeader;

/**
 * 销售订单头应用服务
 *
 * @author xuejun.zhu@china-hand.com 2019-08-05 11:38:52
 */
public interface SoHeaderService {

    SoHeader querySoHeadByNumber(String orderNumber);

}
