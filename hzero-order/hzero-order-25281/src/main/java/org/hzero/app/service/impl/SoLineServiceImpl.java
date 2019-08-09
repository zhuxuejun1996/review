package org.hzero.app.service.impl;

import org.hzero.app.service.SoLineService;
import org.hzero.domain.entity.SoLine;
import org.hzero.infra.mapper.SoLineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 销售订单行应用服务默认实现
 *
 * @author xuejun.zhu@china-hand.com 2019-08-05 11:38:52
 */
@Service
public class SoLineServiceImpl implements SoLineService {

    @Autowired
    private SoLineMapper soLineMapper;
    @Override
    public SoLine querySoLineByHeadIdAndLineNumber(Map<String, Long> params) {
        return soLineMapper.querySoLineByHeadIdAndLineNumber(params);
    }
}
