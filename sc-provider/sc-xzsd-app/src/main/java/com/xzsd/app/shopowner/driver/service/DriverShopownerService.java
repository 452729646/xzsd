package com.xzsd.app.shopowner.driver.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.shopowner.driver.dao.DriverShopownerDao;
import com.xzsd.app.shopowner.driver.entity.DriverShopownerInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * driverShopowner 实现类
 * @Author housum
 * @Date 2020-04-20
 */
@Service
public class DriverShopownerService {
    @Resource
    DriverShopownerDao driverShopownerDao;

    /**
     * APP店长端查看相同地区的司机列表
     * @param driverShopownerInfo
     * @return
     */
    public AppResponse listDriver(DriverShopownerInfo driverShopownerInfo){
        //通过店长的userCode查询storeNo
        String storeNo = driverShopownerDao.selectStoreNo(driverShopownerInfo.getUserCode());
        driverShopownerInfo.setStoreNo(storeNo);
        //查询列表
        List<DriverShopownerInfo> listDriverShopownerInfo = driverShopownerDao.listDriverByPage(driverShopownerInfo);
        DriverShopownerInfo driverShopownerInfo1 = new DriverShopownerInfo();
        driverShopownerInfo1.setList(listDriverShopownerInfo);
        return AppResponse.success("查询成功",driverShopownerInfo1);
    }
}
