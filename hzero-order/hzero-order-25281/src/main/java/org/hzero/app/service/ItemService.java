package org.hzero.app.service;


import org.hzero.domain.entity.Item;

/**
 * 物料应用服务
 *
 * @author xuejun.zhu@china-hand.com 2019-08-05 11:38:52
 */
public interface ItemService {

    Item queryItemByCode(String itemCode);
}


