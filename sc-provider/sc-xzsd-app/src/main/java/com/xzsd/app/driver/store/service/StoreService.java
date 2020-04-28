package com.xzsd.app.driver.store.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.driver.store.dao.StoreDao;
import com.xzsd.app.driver.store.entity.StoreInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * Store实现类
 * @Author housum
 * @Date 2020-04-21
 */
@Service
public class StoreService {

    @Resource
    StoreDao storeDao;

    /**
     * 查询与司机相同地区的门店信息
     * @param storeInfo
     * @return
     */
    public AppResponse listStore(StoreInfo storeInfo){
        List<StoreInfo> listStoreInfo = storeDao.listStoreByPage(storeInfo);
        StoreInfo storeInfoVO = new StoreInfo();
        storeInfoVO.setList(listStoreInfo);
        return AppResponse.success("查询成功",storeInfoVO);
    }
}
