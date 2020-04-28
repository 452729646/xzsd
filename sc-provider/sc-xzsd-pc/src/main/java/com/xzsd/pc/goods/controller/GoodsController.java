package com.xzsd.pc.goods.controller;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.AuthUtils;

import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.goods.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 商品增删改查
 * @Author housum
 * @Date 2020-03-24
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Resource
    private GoodsService goodsService;





    /**
     * demo 新增商品
     * @param  goodsInfo
     * @return AppResponse
     * @author housum
     * @Date 2020-03-24
     */

    @PostMapping("addGoods")
    public AppResponse saveGoods(GoodsInfo goodsInfo) {
        try {
            //获取用户id
            String userCode = SecurityUtils.getCurrentUserId();
            goodsInfo.setCreateBy(userCode);
            AppResponse appResponse = goodsService.saveGoods(goodsInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("商品新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *  删除商品
     * @param
     * @return AppResponse
     * @author housum
     * @Date 2020-03-21
     */
    @PostMapping("deleteGoods")
    public AppResponse deleteGoods(String goodsId) {
        try {
            //获取用户id
            String userCode = SecurityUtils.getCurrentUserId();
            return goodsService.deleteGoods(goodsId,userCode);
        } catch (Exception e) {
            logger.error("商品删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 修改商品
     * @param
     * @return AppResponse
     * @author housum
     * @Date 2020-03-21
     */
    @PostMapping("updateGoods")
    public AppResponse updateGoods(GoodsInfo goodsInfo) {
        try {
            //获取用户id
            String userCode = SecurityUtils.getCurrentUserId();
            goodsInfo.setLastModifiedBy(userCode);
            return goodsService.updateGoods(goodsInfo);
        } catch (Exception e) {
            logger.error("修改商品信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 商品列表(分页)
     * @param goodsInfo
     * @return AppResponse
     * @author housum
     * @Date 2020-03-25
     */
    @RequestMapping(value = "listGoods")
    public AppResponse listGoods(GoodsInfo goodsInfo) {
        try {
            return goodsService.listGoods(goodsInfo);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 上架按钮 修改状态
     * @param
     * @return AppResponse
     * @author housum
     * @Date 2020-03-25
     */
    @RequestMapping(value = "updateGoodsShelfState")
    public AppResponse goodsUpper(GoodsInfo goodsInfo) {
        try {
            //获取用户id
            String userCode = SecurityUtils.getCurrentUserId();
            goodsInfo.setUserId(userCode);
            return goodsService.goodsUpper(goodsInfo);
        } catch (Exception e) {
            logger.error("商品上架错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 下架按钮 修改状态
     * @param
     * @return AppResponse
     * @author housum
     * @Date 2020-03-25
     */
    @RequestMapping(value = "goodsLower")
    public AppResponse goodsLower(String skuNo, int version) {
        try {
            //获取用户id
            String userCode = SecurityUtils.getCurrentUserId();
            return goodsService.goodsLower(skuNo, userCode, version);
        } catch (Exception e) {
            logger.error("商品下架错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 一级分类下来框
     * @param classificationInfo
     * @return
     */
    @RequestMapping(value = "listGoodsClassify")
    public AppResponse listFateCate(String classifyId) {
        try {
            return goodsService.listGoodsClassify(classifyId);
        } catch (Exception e) {
            logger.error("查询分类列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    @RequestMapping("getGoods")
    public AppResponse getGoods(String goodsId){
        try {
            return goodsService.getGoods(goodsId);
        }catch (Exception e) {
            logger.error("查询商品详情异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
