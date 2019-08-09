package org.hzero.infra.mapper;

import org.apache.ibatis.annotations.Param;
import org.hzero.api.dto.OrderArgUpdateRecode;
import org.hzero.api.dto.OrderDto;
import org.hzero.api.dto.OrderRecodeDTO;
import org.hzero.domain.entity.SoLine;
import io.choerodon.mybatis.common.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 销售订单行Mapper
 *
 * @author xuejun.zhu@china-hand.com 2019-08-05 11:38:52
 */
public interface SoLineMapper extends BaseMapper<SoLine> {

    SoLine querySoLineByHeadIdAndLineNumber(Map<String,Long> params);

    List<OrderRecodeDTO> multiQuery(OrderRecodeDTO orderRecodeDTO);

    List<OrderRecodeDTO> queryDetail(@Param("orderNumber") String  OrderNumber);

    List<OrderDto> queryOrderInfo(OrderDto orderRecodeDTO);

    List<OrderRecodeDTO> exportData(OrderRecodeDTO orderRecodeDTO);

    List<OrderDto> testQuery();

//    @Insert(value="INSERT INTO student(AID, SNAME, SEX, BIRTHDAY, AGE) VALUES (#{sid}, #{sname}, #{sex}, #{birthday}, #{age})")
//
//    int insert(Student entity);


//    @Insert(value = "INSERT INTO order_info VALUES (#{orderNumber},#{companyName},#{customerName),#{orderDate},#{orderStatus},#{orderAmount}" +
//            ",#{lineNumber},#{itemCode},#{itemDescription},#{orderQuantityUom},#{unitSellingPrice},#{lineAmount}")
//      int insertOrder(OrderDto orderDto);


    OrderDto updateOrder(OrderArgUpdateRecode orderArgUpdateRecode);
}
