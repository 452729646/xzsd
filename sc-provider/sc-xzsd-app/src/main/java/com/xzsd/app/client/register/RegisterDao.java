package com.xzsd.app.client.register;

import com.xzsd.app.client.user.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterDao {
    /**
     * 统计用户账号数量
     * @param registerInfo 用户信息
     * @return
     */
    int countUserAcct(RegisterInfo registerInfo);

    /**
     * 注册用户
     * @param userInfo 用户信息
     * @return
     */
    int registerUser(RegisterInfo registerInfo);

    /**
     * 在客户表添加客户
     * @param userInfo
     * @return
     */
    int saveClient(RegisterInfo registerInfo);
}
