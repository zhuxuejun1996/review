package org.hzero.infra.repository.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.infra.mapper.ItemMapper;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.hzero.domain.entity.Item;
import org.hzero.domain.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 物料 资源库实现
 *
 * @author xuejun.zhu@china-hand.com 2019-08-05 11:38:52
 */
@Component
public class ItemRepositoryImpl extends BaseRepositoryImpl<Item> implements ItemRepository {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public List<Item> selectItemByCompanyId(String companyId){
        return itemMapper.selectItemByCompanyId(companyId);
    }
}
