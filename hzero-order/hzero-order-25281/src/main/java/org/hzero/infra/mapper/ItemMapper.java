package org.hzero.infra.mapper;

import org.apache.ibatis.annotations.Param;
import org.hzero.domain.entity.Item;
import io.choerodon.mybatis.common.BaseMapper;

import java.util.List;

/**
 * 物料Mapper
 *
 * @author xuejun.zhu@china-hand.com 2019-08-05 11:38:52
 */
public interface ItemMapper extends BaseMapper<Item>{

    List<Item> selectItemByCompanyId(@Param("companyId") String CompanyId);

    Item queryItemByCode(String itemCode);
}
