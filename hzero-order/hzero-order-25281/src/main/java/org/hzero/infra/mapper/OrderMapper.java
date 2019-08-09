//package org.hzero.infra.mapper;
//
//import org.apache.ibatis.annotations.Insert;
//import org.apache.ibatis.annotations.Param;
//import org.hzero.api.dto.OrderArgUpdateRecode;
//import org.hzero.api.dto.OrderDto;
//import org.hzero.api.dto.OrderRecodeDTO;
//
//import java.util.List;
//
///**
// * @author xuejun zhu
// * @create 2019-08-06 11:09
// */
//
//public interface OrderMapper  {
//
//    List<OrderRecodeDTO> multiQuery(OrderRecodeDTO orderRecodeDTO);
//
//    List<OrderRecodeDTO> queryDetail(@Param("orderNumber") String  OrderNumber);
//
//    List<OrderDto> queryOrderInfo(OrderDto orderRecodeDTO);
//
//    List<OrderRecodeDTO> exportData(OrderRecodeDTO orderRecodeDTO);
//
//    List<OrderDto> testQuery();
//
////    @Insert(value="INSERT INTO student(AID, SNAME, SEX, BIRTHDAY, AGE) VALUES (#{sid}, #{sname}, #{sex}, #{birthday}, #{age})")
////
////    int insert(Student entity);
//
//
////    @Insert(value = "INSERT INTO order_info VALUES (#{orderNumber},#{companyName},#{customerName),#{orderDate},#{orderStatus},#{orderAmount}" +
////            ",#{lineNumber},#{itemCode},#{itemDescription},#{orderQuantityUom},#{unitSellingPrice},#{lineAmount}")
////      int insertOrder(OrderDto orderDto);
//
//
//    OrderDto updateOrder(OrderArgUpdateRecode orderArgUpdateRecode);
//
//}
