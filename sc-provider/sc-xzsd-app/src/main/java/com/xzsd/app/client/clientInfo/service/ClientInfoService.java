package com.xzsd.app.client.clientInfo.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.client.clientInfo.dao.ClientInfoDao;
import com.xzsd.app.client.clientInfo.entity.ClientInfo;
import com.xzsd.app.client.user.dao.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class ClientInfoService {

    @Resource
    ClientInfoDao clientInfoDao;
    @Resource
    UserDao userDao;

    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateClientInvite(ClientInfo clientInfo){
        int countInviteCode = userDao.countInviteCode(clientInfo.getInviteCode());
        if (0 == countInviteCode){
            return AppResponse.bizError("不存在此邀请码");
        }
        //修改邀请码
        int count = clientInfoDao.updateInviteCode(clientInfo);
        if (0 == count){
            return AppResponse.bizError("修改失败");
        }
        return AppResponse.success("修改成功");
    }
}
