package com.xzsd.pc.hotgoods.controller;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;

import com.xzsd.pc.goods.entity.GoodListInfo;
import com.xzsd.pc.hotgoods.entity.HotGoodsInfo;
import com.xzsd.pc.hotgoods.entity.HotGoodsVo;
import com.xzsd.pc.hotgoods.service.HotGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 热门商品增删改查
 * @Author housum
 * @Date 2020-03-27
 */
@RestController
@RequestMapping("/hotGoods")
public class HotGoodsController {
    private static final Logger logger = LoggerFactory.getLogger(HotGoodsController.class);

    @Resource
    private HotGoodsService hotGoodsService;


    /**
     * demo 新增热门商品
     *
     * @param hotGoodsInfo
     * @return AppResponse
     * @author housum
     * @Date 2020-03-27
     */

    @PostMapping("saveHotGoods")
    public AppResponse saveHotGoods(HotGoodsInfo hotGoodsInfo) {
        try {
            //获取用户id
            String userCode = SecurityUtils.getCurrentUserId();
            hotGoodsInfo.setCreateBy(userCode);
            AppResponse appResponse = hotGoodsService.saveHotGoods(hotGoodsInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("热门商品新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 新赠热门商品的商品列表
     *
     * @param goodListInfo
     * @return AppResponse
     * @author housum
     * @Date 2020-03-25
     */
    @RequestMapping(value = "hotListGoods")
    public AppResponse hotListGoods(GoodListInfo goodListInfo) {
        try {

            return hotGoodsService.hotListGoods(goodListInfo);
        } catch (Exception e) {
            logger.error("查询商品列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询热门商品列表
     *
     * @author housum
     * @Date 2020-3-27
     */
    @RequestMapping(value = "hotGoodsList")
    public AppResponse hotGoodsList(HotGoodsVo hotGoodsVo) {
        try {
            return hotGoodsService.hotGoodsList(hotGoodsVo);
        } catch (Exception e) {
            logger.error("查询热门商品列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改热门商品信息
     *
     * @author housum
     * @Date 2020-3-27
     */
    @RequestMapping(value = "updateHotGoods")
    public AppResponse updateHotGoods(HotGoodsInfo hotGoodsInfo) {
        try {
            return hotGoodsService.updateHotGoods(hotGoodsInfo);
        } catch (Exception e) {
            logger.error("修改热门商品异常", e);
            System.out.println(e.toString());
            throw e;

        }
    }

    /**
     * 删除热门商品位
     *
     * @author housm
     * @date 2020-3-27
     */
    @RequestMapping(value = "deleteHotGoods")
    public AppResponse deleteHotGoods(String hotGoodsCode) {
        try {
            String userCode =SecurityUtils.getCurrentUserId();
            return hotGoodsService.deleteHotGoods(hotGoodsCode, userCode);
        } catch (Exception e) {
            logger.error("删除热门商品异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 设置展示数量
     * @author housum
     * @date 2020-4-13
     *
     */
    @RequestMapping("setDisplayCnt")
    public AppResponse setDisplayCnt(int displayCnt,int version){
        try{
            String userCode =SecurityUtils.getCurrentUserId();
            return hotGoodsService.setDisplayCnt(displayCnt, userCode,version);
        }catch (Exception e) {
            logger.error("设置热门商品展示数量异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 设置展示数量
     * @author housum
     * @date 2020-4-13
     *
     */
    @RequestMapping("selectDisplayCnt")
    public AppResponse selectDisplayCnt(HotGoodsVo hotGoodsVo){
        try{
            String userCode =SecurityUtils.getCurrentUserId();
            return hotGoodsService.selectDisplayCnt(hotGoodsVo);
        }catch (Exception e) {
            logger.error("查询热门商品展示数量异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }


}
