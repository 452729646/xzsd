package com.xzsd.pc.top.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.top.dao.TopDao;
import com.xzsd.pc.top.entity.TopInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TopService {
    @Resource
    TopDao topDao;

    public AppResponse getTopOfColumn(TopInfo topInfo){
        TopInfo data = topDao.getTopOfColumn(topInfo);
        return AppResponse.success("查询成功",data);
    }
}
