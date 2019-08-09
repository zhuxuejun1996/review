package org.hzero.domain.repository;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.api.dto.OrderArgUpdateRecode;
import org.hzero.api.dto.OrderDto;
import org.hzero.api.dto.OrderRecodeDTO;
import org.hzero.export.vo.ExportParam;
import org.hzero.mybatis.base.BaseRepository;
import org.hzero.domain.entity.SoLine;

import java.util.List;

/**
 * 销售订单行资源库
 *
 * @author xuejun.zhu@china-hand.com 2019-08-05 11:38:52
 */
public interface SoLineRepository extends BaseRepository<SoLine> {

    Page<OrderRecodeDTO> multiQuery(OrderRecodeDTO orderRecodeDTO, PageRequest pageRequest);

    Page<OrderRecodeDTO> queryDetail(String orderNumber,PageRequest pageRequest);

    Page<OrderDto> queryOrderInfo(OrderDto orderRecodeDTO, PageRequest pageRequest);

    Page<OrderRecodeDTO> exportData( OrderRecodeDTO record, PageRequest pageRequest, ExportParam exportParam);

    List<OrderDto> testQuery();

    OrderDto updateOrder(OrderArgUpdateRecode orderArgUpdateRecode);
    
}
