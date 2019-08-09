package org.hzero.app.service.impl;

import org.hzero.app.service.SoHeaderService;
import org.hzero.domain.entity.SoHeader;
import org.hzero.infra.mapper.SoHeaderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 销售订单头应用服务默认实现
 *
 * @author xuejun.zhu@china-hand.com 2019-08-05 11:38:52
 */
@Service
public class SoHeaderServiceImpl implements SoHeaderService {

    @Autowired
    private SoHeaderMapper SoHeaderMapper;
    @Override
    public SoHeader querySoHeadByNumber(String orderNumber) {

        return SoHeaderMapper.querySoHeadByNumber(orderNumber);
    }

}
