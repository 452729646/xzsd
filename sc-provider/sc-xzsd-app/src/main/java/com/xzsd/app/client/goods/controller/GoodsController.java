package com.xzsd.app.client.goods.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.client.commodityClassification.entity.ListSonCateGoodsInfo;
import com.xzsd.app.client.goods.dao.GoodsDao;
import com.xzsd.app.client.goods.entity.EvaluateInfo;
import com.xzsd.app.client.goods.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description app 客户端商品查询
 * @Author housum
 * @Date 2020-4-16
 */
@RestController
@RequestMapping("/clientGoods")
public class GoodsController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
    @Resource GoodsService goodsService;

    /**
     * app客户端显示商品信息
     * @param skuNo
     * @return
     * @author housum
     * @date 2020-4-16
     */
    @PostMapping("getGoods")
    public AppResponse goodsDetail(String goodsId){
        try{
            return goodsService.goodsDetail(goodsId);
        }catch (Exception e){
            logger.error("查询商品信息失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品的评价分页列表
     * @param evaluateInfo
     * @return
     */
    @PostMapping("listGoodsEvaluates")
    public AppResponse listEvaluateBySkuNo(EvaluateInfo evaluateInfo){
        try{
            return goodsService.listEvaluateBySkuNo(evaluateInfo);
        }catch (Exception e){
            logger.error("查询商品评价失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品父分类
     * @param
     * @retrun
     * @author housum
     * @date 2020-4-13
     */
    @RequestMapping("listOneGoodsClassify")
    public AppResponse listFatherCate (){
        try {
            return goodsService.listFatherCate();
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
    @RequestMapping("listGetClassGoods")
    public AppResponse listSonCateGoods(ListSonCateGoodsInfo listSonCateGoodsInfo){
        try{
            return goodsService.listSonCateGoods(listSonCateGoodsInfo);
        }catch (Exception e){
            logger.error("查询子分类商品异常",e);
            System.out.println(e.toString());
            throw e;
        }

    }
}
