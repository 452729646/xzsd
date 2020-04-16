package com.xzsd.app.client.user.dao;

import com.xzsd.app.client.user.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName UserDao
 * @Description 用户管理
 * @Author housum
 * @Date 2020-4-13
 */
@Mapper
public interface UserDao {
    /**
     * 统计用户账号数量
     * @param userInfo 用户信息
     * @return
     */
    int countUserAcct(UserInfo userInfo);

    /**
     * 注册用户
     * @param userInfo 用户信息
     * @return
     */
    int registerUser(UserInfo userInfo);

    /**
     * 在客户表添加客户
     * @param userInfo
     * @return
     */
    int saveClient(UserInfo userInfo);

//    /**
//     * 修改头像url
//     * @param imageName
//     * @param userCode
//     * @return
//     */
//    int updateHeadUrl(@Param("imageName") String imageName,@Param("userCode")String userCode);
}
