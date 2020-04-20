package com.xzsd.app.client.commodityClassification.dao;

import com.xzsd.app.client.commodityClassification.entity.CommodityClassificationInfo;
import com.xzsd.app.client.commodityClassification.entity.ListSonCateGoodsInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * @ClassName CommodityClassificationDao
 * @Description
 * @Author housum
 * @Date 2020-04-13
 */
@Mapper
public interface CommodityClassificationDao {
    /**
     * 获取所有用户信息
     * @param
     * @return 所有用户信息
     */
    List<CommodityClassificationInfo> listFatherCateByPage();

    /**
     * 获取该分类编码下的子分类商品列表
     * @param listSonCateGoodsInfo
     * @return 该分类编码下的子分类商品列表
     */
    List<ListSonCateGoodsInfo> listSonCateGoodsByPage(ListSonCateGoodsInfo listSonCateGoodsInfo);
}
