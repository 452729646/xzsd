package com.xzsd.pc.driver.dao;

import com.xzsd.pc.driver.entity.DriverDetailVO;
import com.xzsd.pc.driver.entity.DriverInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 *
 * @Author housum
 * @Date 2020-4-8
 */
public interface DriverDao {
    /**
     * 统计用户账号数量  检验用户表是否有这个账号
     * @param
     * @return
     */
    int countUserAcct(DriverInfo driverInfo);

    /**
     * 新增司机  在司机表
     * @param driverInfo 商品信息
     * @return
     */
    int saveDriver(DriverInfo driverInfo);

    /**
     * 新增用户 在用户表
     */
    int saveUser(DriverInfo driverInfo);
    /**
     * 司机信息分页查询
     */
    List<DriverInfo> listDriverByShopownerByPage(DriverInfo driverInfo);
    /**
     * 司机信息分页查询
     */
    List<DriverInfo> listDriverByPage(DriverInfo driverInfo);

    /**
     * 查询该司机的详情信息
     */
    DriverDetailVO driverDetail(@Param("driverId") String driverId);

    /**
     * 修改司机信息
     */
    int updateDriver(DriverInfo driverInfo);

    /**
     * 删除司机信息
     */
    int deleteDriver(@Param("listDriverNo") List<String> listDriverNo,@Param("userCode") String userCode);

    /**
     * 通过userCode拿role
     * @param userCode
     * @return
     */
    String getRoleByUserCode(@Param("userCode")String userCode);

    /**
     * 获取driverNo
     * @param userCode
     * @return
     */
    String getDriverNo(@Param("userCode")String userCode);
}
