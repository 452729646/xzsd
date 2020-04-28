package com.xzsd.pc.goods.dao;


import com.xzsd.pc.goods.entity.ClassifyInfo;
import com.xzsd.pc.goods.entity.GoodsClassifyList;
import com.xzsd.pc.goods.entity.GoodsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.method.P;

import java.util.List;
import java.util.Map;

/**
 * @ClassName GoodsDao
 * @Description Demo
 * @Author housum
 * @Date 2020-03-21
 */
@Mapper
public interface GoodsDao {
    /**
     * 统计书号数量
     * @param goodsInfo 用户信息
     * @return
     */
    int countBookNumber(GoodsInfo goodsInfo);

    /**
     * 新增商品
     * @param goodsInfo 商品信息
     * @return
     */
    int saveGoods(GoodsInfo goodsInfo);

    /**
     * 获取所有用户信息
     * @param goodsInfo 用户信息
     * @return 所有用户信息
     */
    List<GoodsInfo> listGoodsByPage(GoodsInfo goodsInfo);

    /**
     * 删除商品信息
     * @param listSkuNo 选中的用户编号集合
     * @param userCode 更新人
     * @return
     */
    int deleteGoods(@Param("listSkuNo")List<String> listSkuNo, @Param("userCode") String userCode);

    /**
     * 修改商品信息
     * @param goodsInfo 商品信息
     * @return 修改结果
     */
    int updateGoods(GoodsInfo goodsInfo);

    /**
     * 查询用户信息
     * @param userCode 用户编号
     * @return 修改结果
     */
    GoodsInfo getUserByUserCode(@Param("userCode") String userCode);


    /**
     * 上架商品信息
     * @param listSkuNo2 选中的用户编号集合
     * @param userCode 更新人
     * @return
     */
    int goodsUpper(List<Map> mapList);

    /**
     * 下架商品信息
     * @param listSkuNo3 选中的用户编号集合
     * @param userCode 更新人
     * @return
     */
    int goodsLower(@Param("listSkuNo3")List<String> listSkuNo3, @Param("userCode") String userCode, @Param("version") int version);

    /**
     * 添加goods的activeMq历史
     */
    int addGoodsActiveMq(String message);

    /**
     * 查询需要下架的商品是否存在是热门商品
     *
     */
    int countInHotGoods(@Param("listSkuNo2")List<String> listSkuNo2);

    /**
     * 查询需要下架的商品是否存在是轮播图 状态是启动中
     *
     */
    int countInBanner(@Param("listSkuNo2")List<String> listSkuNo2);

    /**
     * 查询需要下架的商品是否存在上架的
     *
     */
    int countInSelling(@Param("listSkuNo") List<String> listSkuNo);

    List<ClassifyInfo>listGoodsClassify(@Param("classifyId")String classifyId);

    GoodsInfo getGoods(@Param("goodsId") String goodsId);
}
