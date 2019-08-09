package org.hzero.infra.mapper;

import org.hzero.domain.entity.Company;
import io.choerodon.mybatis.common.BaseMapper;

/**
 * 公司Mapper
 *
 * @author xuejun.zhu@china-hand.com 2019-08-05 11:38:52
 */
public interface CompanyMapper extends BaseMapper<Company> {

    Company queryCompanyByNumber(String companyNumber);

}
