package com.xzsd.pc.picture.conrtroller;



import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;

import com.xzsd.pc.picture.entity.PictureInfo;
import com.xzsd.pc.picture.service.PictureService;
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
@RequestMapping("/picture")
public class PictureController {

    private static final Logger logger = LoggerFactory.getLogger(PictureController.class);

    @Resource
    private PictureService pictureService;
    /**
     * demo 新增轮播图
     * @param  pictureInfo
     * @return AppResponse
     * @author housum
     * @Date 2020-03-25
     */
    @PostMapping("savePicture")
    public AppResponse savePicture(PictureInfo pictureInfo) {
        try {
            //获取用户id
            String userCode = SecurityUtils.getCurrentUserId();
            pictureInfo.setCreateBy(userCode);
            AppResponse appResponse = pictureService.savePicture(pictureInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("轮播图新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *  删除轮播图
     * @param
     * @return AppResponse
     * @author housum
     * @Date 2020-03-25
     */
    @PostMapping("deletePicture")
    public AppResponse deletePicture(String bannerCode) {
        try {
            //获取用户id
            String userCode = SecurityUtils.getCurrentUserId();
            return pictureService.deletePicture(bannerCode,userCode);
        } catch (Exception e) {
            logger.error("轮播图删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * demo 轮播图列表(分页)
     * @param pictureInfo
     * @return AppResponse
     * @author housum
     * @Date 2020-03-25
     */
    @RequestMapping(value = "listPicture")
    public AppResponse listPicture(PictureInfo pictureInfo) {
        try {
            return pictureService.listPicture(pictureInfo);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 启动轮播按钮 修改状态
     * @param
     * @return AppResponse
     * @author housum
     * @Date 2020-03-25
     */
    @RequestMapping(value = "pictureUpper")
    public AppResponse pictureUpper(String bannerCode, int version) {
        try {
            //获取用户id
            String userCode = SecurityUtils.getCurrentUserId();
            return pictureService.pictureUpper(bannerCode, userCode, version);
        } catch (Exception e) {
            logger.error("轮播图启用错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 禁用轮播按钮 修改状态
     * @param
     * @return AppResponse
     * @author housum
     * @Date 2020-03-25
     */
    @RequestMapping(value = "pictureLower")
    public AppResponse pictureLower(String bannerCode, int version) {
        try {
            //获取用户id
            String userCode = SecurityUtils.getCurrentUserId();
            return pictureService.pictureLower(bannerCode, userCode, version);
        } catch (Exception e) {
            logger.error("轮播图禁用错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }




}
