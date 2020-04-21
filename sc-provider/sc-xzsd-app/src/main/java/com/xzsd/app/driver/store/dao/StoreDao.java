package com.xzsd.app.driver.store.dao;

import com.xzsd.app.driver.store.entity.StoreInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * StoreDao
 * @author housum
 * @date 2020-4-21
 */
@Mapper
public interface StoreDao {
    /**
     * 查询与司机相同地区的门店信息
     * @param storeInfo
     * @return
     */
    List<StoreInfo> listStoreByPage(StoreInfo storeInfo);
}
