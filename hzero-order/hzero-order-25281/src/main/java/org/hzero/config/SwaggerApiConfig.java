package org.hzero.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.Tag;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * description
 *
 * @author shuangfei.zhu@hand-china.com 2019/07/21 10:01
 */
@Configuration
public class SwaggerApiConfig {

    public static final String COMPANY = "Company Info";
    public static final String CUSTMOMER = "Customer Info";
    public static final String ITEM = "Item Info";
    public static final String ORDER_HEAD = "Order_Head Info";
    public static final String ORDER_LINE = "Order_Line Info";
    public  static final String ORDER_DTO = "Order_Dto Info";

    @Autowired
    public SwaggerApiConfig(Docket docket) {
        docket.tags(
                new Tag(COMPANY, "公司信息"),
                new Tag(CUSTMOMER, "用户信息"),
                new Tag(ITEM, "物料信息"),
                new Tag(ORDER_HEAD,"订单头信息"),
                new Tag(ORDER_LINE,"订单行信息"),
                new Tag(ORDER_DTO,"订单信息")
        );
    }






}
