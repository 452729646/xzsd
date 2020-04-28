package com.xzsd.app.client.register;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.app.client.user.utils.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class RegisterService {
    @Resource RegisterDao registerDao;

    @Transactional(rollbackFor = Exception.class)
    public AppResponse clientRegister(RegisterInfo registerInfo){
        //检验账号是否存在
        int countUserAcct = registerDao.countUserAcct(registerInfo);
        if (0 != countUserAcct){
            return AppResponse.bizError("此账号已存在,请重新输入");
        }
        registerInfo.setUserCode(StringUtil.getCommonCode(2));
        String password = PasswordUtils.generatePassword(registerInfo.getUserPassword());
        registerInfo.setUserPassword(password);
        registerInfo.setIsDeleted(0);
//        在用户表注册用户
        int count = registerDao.registerUser(registerInfo);
        if (0 == count){
            return AppResponse.bizError("注册失败，请重试！");
        }
//        在客户表增加客户
        int count2 = registerDao.saveClient(registerInfo);
        if (0 == count2){
            return AppResponse.bizError("注册失败，请重试！");
        }
        return AppResponse.success("注册成功");
    }
}
