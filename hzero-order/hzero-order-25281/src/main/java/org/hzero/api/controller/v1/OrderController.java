package org.hzero.api.controller.v1;

import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hzero.api.dto.OrderArgUpdateRecode;
import org.hzero.api.dto.OrderDto;
import org.hzero.api.dto.OrderRecodeDTO;
import org.hzero.config.SwaggerApiConfig;
import org.hzero.core.util.Results;
import org.hzero.domain.repository.SoLineRepository;
import org.hzero.export.annotation.ExcelExport;
import org.hzero.export.vo.ExportParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @author xuejun zhu
 * @create 2019-08-06 13:29
 */
@Api(tags = SwaggerApiConfig.ORDER_DTO)
@RestController("orderController.v1")
@RequestMapping("/v1/{organizationId}/order")
public class OrderController {

   @Autowired
    private SoLineRepository soLineRepository;


    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "复杂条件查找")
    @GetMapping
    public Page<OrderRecodeDTO> pageQueryOrder( OrderRecodeDTO orderRecodeDTO,
                                                PageRequest pageRequest) {
        System.out.println("--------------进来了");
        return soLineRepository.multiQuery(orderRecodeDTO,pageRequest);
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "查询订单详细")
    @GetMapping("/queryDetail")
    public Page<OrderRecodeDTO> queryDetail(String orderNumber,PageRequest pageRequest){
        return soLineRepository.queryDetail(orderNumber,pageRequest);
    }



    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "查询订单数据")
    @GetMapping("/query")
    public Page<OrderDto> queryOrderInfo(OrderDto orderDto, PageRequest pageRequest){
        return soLineRepository.queryOrderInfo(orderDto,pageRequest);
    }



    @GetMapping("/data")
    @ExcelExport(OrderRecodeDTO.class)
    @ApiOperation(value = "数据导出")
    @Permission(level = ResourceLevel.ORGANIZATION)
    public ResponseEntity  export(OrderRecodeDTO record, ExportParam exportParam, HttpServletResponse response, PageRequest pageRequest) {

        return Results.success(soLineRepository.exportData(record, pageRequest,exportParam));

    }

    @GetMapping("/test")
    @ApiOperation(value = "视图测试")
    @Permission(level = ResourceLevel.ORGANIZATION)
    public ResponseEntity testQuery(){
        return Results.success(soLineRepository.testQuery());
    }


    @ApiOperation("编辑订单")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping
    public ResponseEntity<OrderDto> updateOrder(@RequestBody OrderArgUpdateRecode orderArgUpdateRecode){

        return Results.success(soLineRepository.updateOrder(orderArgUpdateRecode));
    }
}
