package com.xzsd.app.client.goods.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
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
@RequestMapping("/goods")
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
    @PostMapping("goodsDetail")
    public AppResponse goodsDetail(String skuNo){
        try{
            return goodsService.goodsDetail(skuNo);
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
    @PostMapping("listEvaluateBySkuNo")
    public AppResponse listEvaluateBySkuNo(EvaluateInfo evaluateInfo){
        try{
            return goodsService.listEvaluateBySkuNo(evaluateInfo);
        }catch (Exception e){
            logger.error("查询商品评价失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
