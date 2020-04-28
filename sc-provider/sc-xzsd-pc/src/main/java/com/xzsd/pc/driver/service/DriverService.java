package com.xzsd.pc.driver.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;


import com.xzsd.pc.driver.dao.DriverDao;
import com.xzsd.pc.driver.entity.DriverDetailVO;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.order.dao.OrderDao;
import com.xzsd.pc.store.entity.StoreInfo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @DescriptionDemo 实现类
 * @Author housum
 * @Date 2020-04-8
 */
@Service
public class DriverService {

    @Resource
    private DriverDao driverDao;
    @Resource
    private OrderDao orderDao;

    /**
     * 密码加密
     * @param rawPassword
     * @return
     */
    public static String generatePassword(String rawPassword) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(rawPassword);
    }
    /**
     *新增司机  还要在用户表新增用户 role=2
     * @param
     * @author housum
     * @date 2020-4-8
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveDriver(DriverInfo driverInfo){
        if ("2".equals(driverInfo.getNowRole())){
            return AppResponse.bizError("店长无权限");
        }
        //检验账号是否存在
        int countUserAcct = driverDao.countUserAcct(driverInfo);
        if (0 != countUserAcct) {
            return AppResponse.success("用户账号已存在，请重新输入！");
        }
        driverInfo.setUserPassword((generatePassword(driverInfo.getUserPassword())));
        String userCode = StringUtil.getCommonCode(4);
        driverInfo.setDriverId(StringUtil.getDriverNo(4));
        driverInfo.setUserCode(userCode);
        driverInfo.setIsDeleted(0);
        //在司机表添加司机
        int count = driverDao.saveDriver(driverInfo);
        //在用户表添加用户
        int count2 = driverDao.saveUser(driverInfo);
        if (0 == count) {
            return AppResponse.success("新增失败，请重试！");
        }
        if (0 == count2){
            return AppResponse.success("在用户表新增用户失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     *司机分页列表查询
     * @param
     * @author housum
     * @date 2020-4-8
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse listDriver(DriverInfo driverInfo){
        String userCode = SecurityUtils.getCurrentUserId();
        String role = driverDao.getRoleByUserCode(userCode);
        //店家 查询相同地区的司机
        if (2 == Integer.valueOf(role)){
            String storeNo = orderDao.storeNoByUserCode(userCode);
            driverInfo.setStoreNo(storeNo);
            List<DriverInfo> driverInfoList = driverDao.listDriverByShopownerByPage(driverInfo);
            return AppResponse.success("查询成功",getPageInfo(driverInfoList));
        }
        //司机本人查询
        if (3 == Integer.valueOf(role)){
            String driverNo = driverDao.getDriverNo(userCode);
            driverInfo.setDriverId(driverNo);
        }
        List<DriverInfo> driverInfoList = driverDao.listDriverByPage(driverInfo);
        return AppResponse.success("查询成功",getPageInfo(driverInfoList));
    }

    /**
     * 查询该司机详细信息
     * @author housum
     * @date 2020-4-8
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse driverDetail(String driverId ){
        DriverDetailVO data = driverDao.driverDetail(driverId );
        if (data == null || "".equals(data)){
            return AppResponse.bizError("查询失败，请重试");
        }
        return AppResponse.success("查询成功",data);
    }

    /**
     * 修改司机信息
     * @author housum
     * @date 2020-4-8
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateDriver (DriverInfo driverInfo){
        if ("2".equals(driverInfo.getNowRole())){
            return AppResponse.bizError("店长无权限");
        }
        AppResponse appResponse = AppResponse.success("修改成功");
        //检验账号是否存在
        int countUserAcct = driverDao.countUserAcct(driverInfo);
        if (0 != countUserAcct) {
            return AppResponse.success("用户账号已存在，请重新输入！");
        }
        driverInfo.setUserPassword((generatePassword(driverInfo.getUserPassword())));
        //修改司机信息
        int count = driverDao.updateDriver(driverInfo);
        if (0 == count){
            return AppResponse.bizError("修改失败，请重试");
        }
        return appResponse;
    }

    /**
     * 删除司机信息
     * @author housum
     * @date 2020-4-8
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteDriver(String driverId , String userCode,String nowRole){
        if ("2".equals(nowRole)){
            return AppResponse.bizError("店长无权限");
        }
        List<String> listDriverNo = Arrays.asList(driverId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功");
        int count = driverDao.deleteDriver(listDriverNo,userCode);
        if (0 == count ){
            appResponse = AppResponse.bizError("删除失败，请重试");
        }
        return appResponse;
    }
}
