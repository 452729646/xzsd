package com.xzsd.app.driver.user.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.driver.user.dao.UserDriverDao;
import com.xzsd.app.driver.user.entity.UserDriverInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * userDriver 实现类
 * @Author housum
 * @Date 2020-04-21
 */
@Service
public class UserDriverService {
    @Resource
    UserDriverDao userDriverDao;

    /**
     * 司机个人信息
     * @param userDriverInfo
     * @return
     */
    public AppResponse userDetail(UserDriverInfo userDriverInfo){
        UserDriverInfo data = userDriverDao.userDetail(userDriverInfo);
        return AppResponse.success("查询成功",data);
    }
}
