package com.xzsd.app.client.user.dao;

import com.xzsd.app.client.user.entity.UserInfo;
import com.xzsd.app.client.user.entity.UserVO;
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

    /**
     * 获取用户信息
     * @param userCode 用户代码
     * @return 用户信息
     */
    String getPwdById(@Param("userCode") String userCode);

    /**
     * 修改密码
     * @param userInfo 用户信息
     * @return
     */
    int updateUserPwd(UserInfo userInfo);

    /**
     * 查询是否存在此邀请码
     * @param inviteCode
     * @return
     */
    int countInviteCode(String inviteCode);

    /**
     * 修改邀请码
     * @param userInfo
     * @return
     */
    int updateInviteCode(UserInfo userInfo);

    /**
     * 查询头像 和名称
     * @param userInfo
     * @return
     */
    UserVO selectUserName(UserInfo userInfo);

    /**
     * 修改头像
     * @param userInfo
     * @return
     */
    int updateHeadPicture(UserInfo userInfo);

    String roleByUserCode(@Param("userCode")String userCode);


//    /**
//     * 修改头像url
//     * @param imageName
//     * @param userCode
//     * @return
//     */
//    int updateHeadUrl(@Param("imageName") String imageName,@Param("userCode")String userCode);
}
