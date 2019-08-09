package org.hzero.domain.repository;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.BaseRepository;
import org.hzero.domain.entity.Item;

import java.util.List;

/**
 * 物料资源库
 *
 * @author xuejun.zhu@china-hand.com 2019-08-05 11:38:52
 */
public interface ItemRepository extends BaseRepository<Item>{

    List<Item> selectItemByCompanyId (String companyId);

}
