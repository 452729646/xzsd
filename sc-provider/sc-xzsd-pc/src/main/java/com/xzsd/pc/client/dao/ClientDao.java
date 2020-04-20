package com.xzsd.pc.client.dao;


import com.xzsd.pc.client.entity.ClientInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.method.P;

import java.util.List;

/**
 * @ClassName clientDao
 * @Description Demo
 * @Author housum
 * @Date 2020-03-21
 */
@Mapper
public interface ClientDao {
    /**
     * 获取所有客户信息
     * @param clientInfo 用客户信息
     * @return 所有用户信息
     */
    List<ClientInfo> listClientByPage(ClientInfo clientInfo);

    /**
     * 通过userCode拿role
     * @param userCode
     * @return
     */
    String getRoleByUserCode(@Param("userCode")String userCode);

    /**
     * 获取storeNo
     * @param userCode
     * @return
     */
    String getStoreNo(@Param("userCode")String userCode);
}
