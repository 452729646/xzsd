package com.xzsd.pc.store.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;

import com.xzsd.pc.order.dao.OrderDao;
import com.xzsd.pc.store.dao.StoreDao;
import com.xzsd.pc.selectCombox.RegionInfo;
import com.xzsd.pc.store.entity.StoreDetailVo;
import com.xzsd.pc.store.entity.StoreInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @DescriptionDemo 实现类
 * @Author housum
 * @Date 2020-04-2
 */
@Service
public class StoreService {
    @Resource
    private StoreDao storeDao;
    @Resource OrderDao orderDao;

    /**
     * demo 新增门店
     * @param storeInfo
     * @return
     * @Author housum
     * @Date 2020-04-2
     */
    //回滚
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveStore(StoreInfo storeInfo){
        if ("2".equals(storeInfo.getNowRole())){
            return AppResponse.bizError("店长无权限");
        }
        // 校验门店名称是否存在
        int countStoreName = storeDao.countStoreName(storeInfo);
        if(0 != countStoreName) {
            return AppResponse.bizError("此门店名称已存在，请重新输入！");
        }
        int countUserAcct = storeDao.countUserAcct(storeInfo);
        //用于判断该店长账号是否已经绑定门店
        int countManagerAcct = storeDao.countManagerAcct(storeInfo);
        if( 0 == countUserAcct){
            return AppResponse.bizError("此店长账号不存在，请重新输入！");
        }else{
            if (0 == countManagerAcct){
                String storeNo = StringUtil.getStoreNo();
                storeInfo.setStoreId(storeNo);
                storeInfo.setInvitationCode(storeNo);
                storeInfo.setIsDeleted(0);
                //新增门店
                int count = storeDao.saveStore(storeInfo);
                if(0 == count) {
                    return AppResponse.bizError("新增失败，请重试！");
                }
                return AppResponse.success("新增成功！");
            }else {
                return AppResponse.bizError("此店长账号已绑定另外门店，请重新输入！");
            }

        }

    }

    /**
     * 查询门店列表
     * @param storeInfo
     * @return
     * @author housum
     * @date 2020-4-2
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse listStore(StoreInfo storeInfo){
        //没有登录 获取的userCode是测试用户  会报错
        String userCode = SecurityUtils.getCurrentUserId();
        //通过userCode查询role
        int role = orderDao.roleByUserCode(userCode);
        //role=2为店长
        if (2 == role){
            //拿出该店长的门店编号
            String storeNo = orderDao.storeNoByUserCode(userCode);
            storeInfo.setStoreId(storeNo);
        }
        List<StoreInfo> listInfoStore = storeDao.listStoreByPage(storeInfo);
        return AppResponse.success("查询成功！",  getPageInfo(listInfoStore));
    }

    /**
     * 查询门店详情
     * @param
     * @return
     * @author housum
     * @date 2020-4-3
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse storeDetail(StoreDetailVo storeDetailVo){
        StoreDetailVo data = storeDao.storeDetail(storeDetailVo);
        if (data == null || "".equals(data) ){
            return AppResponse.bizError("查询失败，请重试");
        }
        return AppResponse.success("查询成功！",data);
    }

    /**
     * 修改门店信息
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateStore(StoreInfo storeInfo){
        AppResponse appResponse = AppResponse.success("修改成功");
        //检验门店名称是否存在
        int countStoreName = storeDao.countStoreName(storeInfo);
        if(0 != countStoreName) {
            return AppResponse.bizError("此门店名称已存在，请重新输入！");
        }
        //是否存在该店长账号
        int countUserAcct = storeDao.countUserAcct(storeInfo);
        //用于判断该店长账号是否已经绑定门店
        int countManagerAcct = storeDao.countManagerAcct(storeInfo);
        if( 0 == countUserAcct){
            return AppResponse.bizError("此店长账号不存在，请重新输入！");
        }else {
            if (0 == countManagerAcct) {
                int count = storeDao.updateStore(storeInfo);
                if (0 == count) {
                    appResponse = AppResponse.versionError("数据有变化，请刷新！");
                    return appResponse;
                }
                return appResponse;
            } else {
                return AppResponse.bizError("此店长账号已绑定另外门店，请重新输入！");
            }
        }

    }

    /**
     * 删除门店信息
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteStore(String storeId , String userCode,String nowRole){
        if ("2".equals(nowRole)){
            return AppResponse.bizError("店长无权限");
        }
        List<String> listStoreNo = Arrays.asList(storeId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除用户istSkuN
        int count = storeDao.deteleStore(listStoreNo,userCode);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }


    /**
     * 地区 省的下拉框
     * @param regionInfo
     * @author housum
     * @date 2020-4-13
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse province(RegionInfo regionInfo){
        List<RegionInfo> listProvinceInfo = storeDao.listProvinceByPage(regionInfo);
        return AppResponse.success("查询成功！",  getPageInfo(listProvinceInfo));
    }

    /**
     *  市下拉框
     * @param regionInfo
     * @author housum
     * @date 2020-4-13
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse city(RegionInfo regionInfo){
        List<RegionInfo> listCityInfo = storeDao.listCityByPage(regionInfo);
        return AppResponse.success("查询成功！",  getPageInfo(listCityInfo));
    }

    /**
     *  区下拉框
     * @param regionInfo
     * @author housum
     * @date 2020-4-13
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse area(RegionInfo regionInfo){
        List<RegionInfo> listCityInfo = storeDao.listAreaByPage(regionInfo);
        return AppResponse.success("查询成功！",  getPageInfo(listCityInfo));
    }

}
