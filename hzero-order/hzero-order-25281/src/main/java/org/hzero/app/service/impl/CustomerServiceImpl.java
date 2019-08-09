package org.hzero.app.service.impl;

import org.hzero.app.service.CustomerService;
import org.hzero.domain.entity.Customer;
import org.hzero.domain.repository.CustomerRepository;
import org.hzero.infra.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 客户应用服务默认实现
 *
 * @author xuejun.zhu@china-hand.com 2019-08-05 11:38:52
 */
@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerRepository customerRepository;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Customer> selCustomer(String companyId){
        return customerRepository.selCustomer(companyId);

    }

    @Autowired
    private CustomerMapper CustomerMapper;

    @Override
    public Customer queryCustomerByNumber(String customerNumber) {
        return CustomerMapper.queryCustomerByNumber(customerNumber);
    }

}
