package com.xzsd.app.shopowner.driver.dao;

import com.xzsd.app.shopowner.driver.entity.DriverShopownerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * OrderShopownerDao
 * @author housum
 * @date 2020-4-20
 */
@Mapper
public interface DriverShopownerDao {
    /**
     * 通过店长的userCode查询storeNo
     * @param userCode
     * @return
     */
    String selectStoreNo(@Param("userCode")String userCode);

    /**
     * 查询该门店的司机列表
     * @param driverShopownerInfo
     * @return
     */
    List<DriverShopownerInfo> listDriverByPage(DriverShopownerInfo driverShopownerInfo);
}
