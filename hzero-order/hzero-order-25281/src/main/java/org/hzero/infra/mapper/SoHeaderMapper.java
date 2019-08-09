package org.hzero.infra.mapper;

import org.hzero.domain.entity.SoHeader;
import io.choerodon.mybatis.common.BaseMapper;

/**
 * 销售订单头Mapper
 *
 * @author xuejun.zhu@china-hand.com 2019-08-05 11:38:52
 */
public interface SoHeaderMapper extends BaseMapper<SoHeader> {

    //通过订单编号去查订单头信息
    SoHeader querySoHeadByNumber(String orderNumber);

}
