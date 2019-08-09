package org.hzero.infra.repository.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.api.dto.OrderArgUpdateRecode;
import org.hzero.api.dto.OrderDto;
import org.hzero.api.dto.OrderRecodeDTO;
import org.hzero.domain.entity.SoLine;
import org.hzero.export.vo.ExportParam;
import org.hzero.infra.mapper.SoLineMapper;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.hzero.domain.repository.SoLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 销售订单行 资源库实现
 *
 * @author xuejun.zhu@china-hand.com 2019-08-05 11:38:52
 */
@Component
public class SoLineRepositoryImpl extends BaseRepositoryImpl<SoLine> implements SoLineRepository {

    @Autowired
    SoLineMapper soLineMapper;


    @Override
    public Page<OrderRecodeDTO> multiQuery (OrderRecodeDTO orderRecodeDTO, PageRequest pageRequest){
        return PageHelper.doPage(pageRequest, () -> soLineMapper.multiQuery(orderRecodeDTO));
    }

    @Override
    public Page<OrderRecodeDTO> queryDetail(String orderNumber,PageRequest pageRequest){
        return PageHelper.doPage(pageRequest, () -> soLineMapper.queryDetail(orderNumber));
    }

    @Override
    public Page<OrderDto> queryOrderInfo (OrderDto orderDto, PageRequest pageRequest){
        return PageHelper.doPage(pageRequest, () -> soLineMapper.queryOrderInfo(orderDto));
    }

    @Override
    public Page<OrderRecodeDTO> exportData(OrderRecodeDTO record , PageRequest pageRequest, ExportParam exportParam){
        return PageHelper.doPage(pageRequest,() -> soLineMapper.exportData(record));

    }

    @Override
    public List<OrderDto> testQuery(){
        return soLineMapper.testQuery();
    }


    @Override
    public OrderDto updateOrder(OrderArgUpdateRecode orderArgUpdateRecode){
        return soLineMapper.updateOrder(orderArgUpdateRecode);
   }


}
