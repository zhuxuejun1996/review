package org.hzero.infra.mapper;

import org.apache.ibatis.annotations.Param;
import org.hzero.domain.entity.Company;
import org.hzero.domain.entity.Customer;
import io.choerodon.mybatis.common.BaseMapper;

import java.util.List;

/**
 * 客户Mapper
 *
 * @author xuejun.zhu@china-hand.com 2019-08-05 11:38:52
 */
public interface CustomerMapper extends BaseMapper<Customer> {

    List<Customer> selCustomer( @Param("companyId") String companyId);

    Customer queryCustomerByNumber(String customerNumber);
}
