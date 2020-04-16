package com.xzsd.pc.client.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;

import com.xzsd.pc.client.dao.ClientDao;
import com.xzsd.pc.client.entity.ClientInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @DescriptionDemo 实现类
 * @Author housum
 * @Date 2020-03-25
 */
@Service
public class ClientService {

    @Resource
    private ClientDao clientDao;

    /**
     * demo 查询商品列表（分页）
     * @param clientInfo
     * @return
     * @Author housum
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse listClient(ClientInfo clientInfo) {
        List<ClientInfo>  clinetInfoList = clientDao.listClientByPage(clientInfo);
        return AppResponse.success("查询成功！",getPageInfo(clinetInfoList));
    }
}
