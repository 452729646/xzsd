package com.xzsd.pc.driver.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;

import com.xzsd.pc.driver.dao.DriverDao;
import com.xzsd.pc.driver.entity.DriverDetailVO;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.store.entity.StoreInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @DescriptionDemo 实现类
 * @Author housum
 * @Date 2020-04-8
 */
@Service
public class DriverService {

    @Resource
    private DriverDao driverDao;


    /**
     *新增司机  还要在用户表新增用户 role=3
     * @param
     * @author housum
     * @date 2020-4-8
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveDriver(DriverInfo driverInfo){
        //检验账号是否存在
        int countUserAcct = driverDao.countUserAcct(driverInfo);
        if (0 != countUserAcct) {
            return AppResponse.success("用户账号已存在，请重新输入！");
        }
        String userCode = StringUtil.getCommonCode(4);
        driverInfo.setDriverNo(StringUtil.getDriverNo(4));
        driverInfo.setUserCode(userCode);
        driverInfo.setIsDeleted(0);
        int count = driverDao.saveDriver(driverInfo);
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
        List<DriverInfo> driverInfoList = driverDao.listDriverByPage(driverInfo);
        return AppResponse.success("查询成功",driverInfoList);
    }

    /**
     * 查询该司机详细信息
     * @author housum
     * @date 2020-4-8
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse driverDetail(String driverNo ,int version){
        DriverDetailVO data = driverDao.driverDetail(driverNo , version);
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
        AppResponse appResponse = AppResponse.success("修改成功");
        //检验账号是否存在
        int countUserAcct = driverDao.countUserAcct(driverInfo);
        if (0 != countUserAcct) {
            return AppResponse.success("用户账号已存在，请重新输入！");
        }
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
    public AppResponse deleteDriver(String driverNo , String userCode){
        List<String> listDriverNo = Arrays.asList(driverNo.split(","));
        AppResponse appResponse = AppResponse.success("删除成功");
        int count = driverDao.deleteDriver(listDriverNo,userCode);
        if (0 == count ){
            appResponse = AppResponse.bizError("删除失败，请重试");

        }
        return appResponse;
    }
}
