package org.hzero.app.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hzero.app.service.*;
import org.hzero.boot.imported.app.service.IDoImportService;
import org.hzero.boot.imported.infra.validator.annotation.ImportService;
import org.hzero.domain.entity.*;
import org.hzero.domain.repository.SoHeaderRepository;
import org.hzero.domain.repository.SoLineRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xuejun zhu
 * @create 2019-08-08 19:32
 */
@ImportService(templateCode = "TEST1")
public class ImportServiceTwoImpl implements IDoImportService {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SoLineRepository soLineRepository;

    @Autowired
    private SoHeaderRepository soHeaderRepository;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private SoHeaderService soHeaderService;

    @Autowired
    private SoLineService soLineService;

    @Override
    public Boolean doImport(String data){
        System.out.println(data);
        Order order = null;


       try {
           //从数据串中读取数据到实体类中
           order = objectMapper.readValue(data, Order.class);
           System.out.println("order: "+order.getCompanyNumber());

           //公司存在
           Company Company = companyService.queryCompanyByNumber(order.getCompanyNumber());

           //客户存在
           Customer hodrCustomer = customerService.queryCustomerByNumber(order.getCustomerNumber());

           //物料存在
           Item hodrItem = itemService.queryItemByCode(order.getItemCode());
           //获取订单头
           SoHeader header1 = soHeaderService.querySoHeadByNumber(order.getOrderNumber());

           //判断订单头是否存在，不存在就插入订单头信息
           if(header1 == null){
               SoHeader header2 = new SoHeader();
               header2.setOrderNumber(order.getOrderNumber());
               header2.setOrderStatus(order.getOrderStatus());
               header2.setOrderDate(order.getOrderDate());
               header2.setCustomerId(hodrCustomer.getCustomerId());
               header2.setCompanyId(Company.getCompanyId());
               soHeaderRepository.insert(header2);
           }
           //获取订单行
           SoLine soLine = new SoLine();
           soLine.setLineNumber(order.getLineNumber());
           soLine.setSoHeaderId(header1.getSoHeaderId());
           soLine.setItemId(hodrItem.getItemId());
           soLine.setOrderQuantity(order.getOrderQuantity());
           soLine.setOrderQuantityUom(order.getOrderQuantityUom());
           soLine.setUnitSellingPrice(order.getUnitSellingPrice());
           soLine.setDescription(order.getDescription());

           Map<String,Long> params = new HashMap<>();
           params.put("headId",soLine.getSoHeaderId());
           params.put("lineNumber",soLine.getLineNumber());
           //判断订单行是否存在，不存在就插入
           SoLine soLine1 = soLineService.querySoLineByHeadIdAndLineNumber(params);
           System.out.println("--->>>>>>>>>>>>>");
           if(soLine1 == null){
               soLineRepository.insert(soLine);
               System.out.println("== ==== ==== ===== ======");
           }else {
               System.out.println("该记录已经存在");
           }
       } catch (IOException e) {
           e.printStackTrace();
           // 失败
           return false;
       }
        return true;
    }
}