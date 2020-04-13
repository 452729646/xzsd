package com.xzsd.app.client.user.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;

import com.xzsd.app.client.user.dao.UserDao;
import com.xzsd.app.client.user.entity.UserInfo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @DescriptionDemo 实现类
 * @Author housum
 * @Date 2020-04-13
 */
@Service
public class UserService {

    @Resource
    UserDao userdao;

    public static String generatePassword(String rawPassword) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(rawPassword);
    }
    /**
     * 注册用户
     * @param userInfo
     * @return
     * @author housum
     * @date 2020-4-13
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse registerUser(UserInfo userInfo){
        int countUserAcct = userdao.countUserAcct(userInfo);

        if (0 != countUserAcct){
            return AppResponse.bizError("此账号已存在,请重新输入");

        }
        if (!userInfo.getUserPwd().equals(userInfo.getUserPwd2())){
            return AppResponse.bizError("输入的密码不一致,请重新输入");
        }
        userInfo.setUserCode(StringUtil.getCommonCode(2));
        String password = generatePassword(userInfo.getUserPwd());
        userInfo.setUserPwd(password);
        userInfo.setIsDeleted(0);
        int count = userdao.registerUser(userInfo);
        if (0 == count){
            return AppResponse.bizError("注册失败，请重试！");
        }
        return AppResponse.success("注册成功");

    }

}
