package com.xzsd.app.client.clientInfo.dao;

import com.xzsd.app.client.clientInfo.entity.ClientInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClientDao
 * @author housum
 * @date 2020-4-27
 */
@Mapper
public interface ClientInfoDao {
    /**
     * 修改邀请码
     * @param clientInfo
     * @return
     */
    int updateInviteCode(ClientInfo clientInfo);
}
