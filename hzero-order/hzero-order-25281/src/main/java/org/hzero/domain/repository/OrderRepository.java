//package org.hzero.domain.repository;
//
//import io.choerodon.mybatis.pagehelper.domain.PageRequest;
//import org.hzero.api.dto.OrderArgUpdateRecode;
//import org.hzero.api.dto.OrderDto;
//import org.hzero.api.dto.OrderRecodeDTO;
//import io.choerodon.core.domain.Page;
//import org.hzero.export.vo.ExportParam;
//import org.hzero.mybatis.base.BaseRepository;
//
//import java.util.List;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * @author xuejun zhu
// * @create 2019-08-06 13:39
// */
//
//public interface OrderRepository{
//
//    Page<OrderRecodeDTO> multiQuery(OrderRecodeDTO orderRecodeDTO, PageRequest pageRequest);
//
//    Page<OrderRecodeDTO> queryDetail(String orderNumber,PageRequest pageRequest);
//
//    Page<OrderDto> queryOrderInfo(OrderDto orderRecodeDTO, PageRequest pageRequest);
//
//    Page<OrderRecodeDTO> exportData( OrderRecodeDTO record, PageRequest pageRequest, ExportParam exportParam);
//
//    List<OrderDto> testQuery();
//
//   // int insertOrder(OrderDto orderDto);
//
//    OrderDto updateOrder(OrderArgUpdateRecode orderArgUpdateRecode);
//
//}
