package com.xzsd.pc.store.dao;


import com.xzsd.pc.store.entity.StoreDetailVo;
import com.xzsd.pc.store.entity.StoreInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StoreDao {

    /**
     * 统计该门店名称数量
     * @param storeInfo 门店信息
     * @return
     */
    int countStoreName(StoreInfo storeInfo);
    /**
     * 统计是否存在该店长名称数量
     * @param storeInfo 门店信息
     * @return
     */
    int countUserAcct(StoreInfo storeInfo);
    /**
     * 统计该店长账号是否已经绑定门店数量
     * @param storeInfo 门店信息
     * @return
     */
    int countManagerAcct(StoreInfo storeInfo);

    /**
     * 新增门店
     * @param storeInfo 商品信息
     * @return
     */
    int saveStore(StoreInfo storeInfo);
    /**
     * 查询门店李彪
     * @param storeInfo 商品信息
     * @return
     */
    List<StoreInfo> listStoreByPage(StoreInfo storeInfo);

    /**
     * 查询门店详情
     */
    StoreDetailVo storeDetail(@Param("storeNo") String storeNo, @Param("version") int version);

    /**
     * 修改门店信息
     * @param storeInfo
     *
     */
    int updateStore(StoreInfo storeInfo);

    /**
     * 删除门店信息
     */
    int deteleStore(@Param("listStoreNo")List<String> listStoreNo,@Param("userCode") String userCode);


}
