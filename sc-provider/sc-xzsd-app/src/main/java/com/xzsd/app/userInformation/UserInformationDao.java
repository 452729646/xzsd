package com.xzsd.app.userInformation;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInformationDao {
    /**
     * 店长个人信息
     * @param userInformationInfo
     * @return
     */
    UserInformationInfo getUserManager(UserInformationInfo userInformationInfo);

    /**
     * 司机个人信息
     * @param userInformationInfo
     * @return
     */
    UserInformationInfo getUserDriver(UserInformationInfo userInformationInfo);

    /**
     * 客户个人信息
     * @param userInformationInfo
     * @return
     */
    UserInformationInfo getUserClient(UserInformationInfo userInformationInfo);

    /**
     * 修改密码
     * @param userInfo 用户信息
     * @return
     */
    int updateUserPwd(UserInformationInfo userInformationInfo);

}
