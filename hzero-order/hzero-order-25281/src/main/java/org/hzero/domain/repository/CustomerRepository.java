package org.hzero.domain.repository;

import org.hzero.mybatis.base.BaseRepository;
import org.hzero.domain.entity.Customer;

import java.util.List;

/**
 * 客户资源库
 *
 * @author xuejun.zhu@china-hand.com 2019-08-05 11:38:52
 */
public interface CustomerRepository extends BaseRepository<Customer> {

    List<Customer> selCustomer(String companyId);
}
