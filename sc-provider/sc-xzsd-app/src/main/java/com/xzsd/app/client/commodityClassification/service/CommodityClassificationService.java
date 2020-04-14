package com.xzsd.app.client.commodityClassification.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.client.commodityClassification.dao.CommodityClassificationDao;
import com.xzsd.app.client.commodityClassification.entity.CommodityClassificationInfo;
import com.xzsd.app.client.commodityClassification.entity.ListSonCateGoodsInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommodityClassificationService {

    @Resource CommodityClassificationDao commodityClassificationDao;

    /**
     * 查询父分类列表

     *
     * @param
     * @return
     * @Author housum
     * @Date 2020-04-13
     */
    //回滚

    public AppResponse listFatherCate(){
        List<CommodityClassificationInfo> fatherCateInfoList = commodityClassificationDao.listFatherCate();
        return AppResponse.success("查询成功！",fatherCateInfoList);
    }

    /**
     * 查询子分类商品
     * @return AppResponse
     * @param listSonCateGoodsInfo
     * @author housum
     * @date 2020-4-14
     */

    public AppResponse listSonCateGoods(ListSonCateGoodsInfo listSonCateGoodsInfo){
        List<ListSonCateGoodsInfo> listSonCateGoodsInfoList = commodityClassificationDao.listSonCateGoods(listSonCateGoodsInfo);
        return AppResponse.success("查询成功",listSonCateGoodsInfoList);
    }

}
