package com.xzsd.app.driver.user.dao;

import com.xzsd.app.driver.user.entity.UserDriverInfo;

/**
 * UserDriverDao
 * @author housum
 * @date 2020-4-21
 */
public interface UserDriverDao {
    /**
     * 查询司机个人信息
     * @param userDriverInfo
     * @return
     */
    UserDriverInfo userDetail(UserDriverInfo userDriverInfo);
}
