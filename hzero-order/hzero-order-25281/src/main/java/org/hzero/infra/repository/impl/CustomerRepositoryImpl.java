package org.hzero.infra.repository.impl;

import org.hzero.infra.mapper.CustomerMapper;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.hzero.domain.entity.Customer;
import org.hzero.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 客户 资源库实现
 *
 * @author xuejun.zhu@china-hand.com 2019-08-05 11:38:52
 */
@Component
public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer> implements CustomerRepository {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> selCustomer(String companyId){
        return customerMapper.selCustomer(companyId);
    }
}
