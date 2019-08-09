package org.hzero.app.service.impl;

import org.hzero.app.service.CompanyService;
import org.hzero.domain.entity.Company;
import org.hzero.infra.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 公司应用服务默认实现
 *
 * @author xuejun.zhu@china-hand.com 2019-08-05 11:38:52
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper CompanyMapper;
    @Override
    public Company queryCompanyByNumber(String companyNumber) {
        return CompanyMapper.queryCompanyByNumber(companyNumber);
    }
}
