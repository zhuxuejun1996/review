package org.hzero.app.service;

import org.hzero.domain.entity.Customer;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

/**
 * 客户应用服务
 *
 * @author xuejun.zhu@china-hand.com 2019-08-05 11:38:52
 */
public interface CustomerService {

    List<Customer> selCustomer (String company);

    Customer queryCustomerByNumber(String customerNumber);
}
