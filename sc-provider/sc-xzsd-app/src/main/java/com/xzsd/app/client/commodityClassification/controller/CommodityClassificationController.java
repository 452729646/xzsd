package com.xzsd.app.client.commodityClassification.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.client.commodityClassification.entity.CommodityClassificationInfo;
import com.xzsd.app.client.commodityClassification.entity.ListSonCateGoodsInfo;
import com.xzsd.app.client.commodityClassification.service.CommodityClassificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 商品分类页
 * @Author housum
 * @Date 2020-04-13
 */

@RestController
@RequestMapping("/classification")
public class CommodityClassificationController {

    private static final Logger logger = LoggerFactory.getLogger(CommodityClassificationController.class);
    @Resource CommodityClassificationService commodityClassificationService;

    /**
     * 查询商品父分类
     * @param
     * @retrun
     * @author housum
     * @date 2020-4-13
     */
    @RequestMapping("listFatherCate")
    public AppResponse listFatherCate (){
        try {
            return commodityClassificationService.listFatherCate();
        } catch (Exception e) {
            logger.error("查询父分类列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询子分类的商品
     * @param
     * @author housum
     * @date 2020-4-14
     */
    @RequestMapping("listSonCateGoods")
    public AppResponse listSonCateGoods(ListSonCateGoodsInfo listSonCateGoodsInfo){
        try{
            return commodityClassificationService.listSonCateGoods(listSonCateGoodsInfo);
        }catch (Exception e){
            logger.error("查询子分类商品异常",e);
            System.out.println(e.toString());
            throw e;
        }

    }


}
