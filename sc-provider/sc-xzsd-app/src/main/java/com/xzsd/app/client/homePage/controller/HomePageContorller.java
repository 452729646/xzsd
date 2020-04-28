package com.xzsd.app.client.homePage.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.client.homePage.entity.ListHotGoodsInfo;
import com.xzsd.app.client.homePage.entity.PictureInfo;
import com.xzsd.app.client.homePage.service.HomePageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 商品增删改查
 * @Author housum
 * @Date 2020-03-24
 */
@RestController
@RequestMapping("/clientHome")
public class HomePageContorller {

    private static final Logger logger = LoggerFactory.getLogger(HomePageContorller.class);
    @Resource HomePageService homePageService;

    /**
     * demo 轮播图列表
     * @param pictureInfo
     * @return AppResponse
     * @author housum
     * @Date 2020-04-13
     */
    @RequestMapping(value = "listRotationCharHome")
    public AppResponse listPicture(PictureInfo pictureInfo) {
        try {
            return homePageService.listPicture(pictureInfo);
        } catch (Exception e) {
            logger.error("查询轮播图列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询热门商品列表
     * @param
     * @return AppResponse
     * @author housum
     * @date 2020-4-13
     */
    @RequestMapping("listHotGoods")
    public AppResponse listHotGoods(){
        try {
            return homePageService.listHotGoods();
        } catch (Exception e) {
            logger.error("查询轮播图列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
