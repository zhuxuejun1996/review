//package org.hzero.infra.repository.impl;
//
//import io.choerodon.mybatis.pagehelper.PageHelper;
//import io.choerodon.mybatis.pagehelper.domain.PageRequest;
//import org.hzero.api.dto.OrderArgUpdateRecode;
//import org.hzero.api.dto.OrderDto;
//import org.hzero.api.dto.OrderRecodeDTO;
//import org.hzero.domain.repository.OrderRepository;
//import org.hzero.export.vo.ExportParam;
//import org.hzero.infra.mapper.OrderMapper;
//import io.choerodon.core.domain.Page;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import javax.servlet.http.HttpServletResponse;
//
//
///**
// * @author xuejun zhu
// * @create 2019-08-06 11:10
// */
//@Component
//public class OrderRepositoryImpl  implements OrderRepository {
//
//    @Autowired
//     OrderMapper orderMapper;
//
//
//   @Override
//    public Page<OrderRecodeDTO> multiQuery (OrderRecodeDTO orderRecodeDTO, PageRequest pageRequest){
//        return PageHelper.doPage(pageRequest, () -> orderMapper.multiQuery(orderRecodeDTO));
//    }
//
//    @Override
//    public Page<OrderRecodeDTO> queryDetail(String orderNumber,PageRequest pageRequest){
//       return PageHelper.doPage(pageRequest, () -> orderMapper.queryDetail(orderNumber));
//    }
//
//    @Override
//    public Page<OrderDto> queryOrderInfo (OrderDto orderDto, PageRequest pageRequest){
//        return PageHelper.doPage(pageRequest, () -> orderMapper.queryOrderInfo(orderDto));
//    }
//
//    @Override
//    public Page<OrderRecodeDTO> exportData(OrderRecodeDTO record , PageRequest pageRequest, ExportParam exportParam){
//        return PageHelper.doPage(pageRequest,() -> orderMapper.exportData(record));
//
//    }
//
//    @Override
//    public List<OrderDto> testQuery(){
//       return orderMapper.testQuery();
//    }
//
//    @Override
//    public OrderDto updateOrder(OrderArgUpdateRecode orderArgUpdateRecode){
//       return orderMapper.updateOrder(orderArgUpdateRecode);
//    }
//
//
//
//}
