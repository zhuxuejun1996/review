package org.hzero.app.service.impl;

import org.hzero.app.service.ItemService;
import org.hzero.domain.entity.Item;
import org.hzero.infra.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 物料应用服务默认实现
 *
 * @author xuejun.zhu@china-hand.com 2019-08-05 11:38:52
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper hodrItemMapper;
    @Override
    public Item queryItemByCode(String itemCode) {
        return hodrItemMapper.queryItemByCode(itemCode);
    }

}
