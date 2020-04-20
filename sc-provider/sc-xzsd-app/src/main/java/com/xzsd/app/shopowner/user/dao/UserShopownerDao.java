package com.xzsd.app.shopowner.user.dao;

import com.xzsd.app.shopowner.user.entity.UserInfo;
import com.xzsd.app.shopowner.user.entity.UserShopownerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * UserShopownerDao
 * @author housum
 * @date 2020-4-20
 */
@Mapper
public interface UserShopownerDao {
    /**
     * 查询店长信息
     * @param userShopownerInfo
     * @return
     */
    UserShopownerInfo userDetail(UserShopownerInfo userShopownerInfo);

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
}
