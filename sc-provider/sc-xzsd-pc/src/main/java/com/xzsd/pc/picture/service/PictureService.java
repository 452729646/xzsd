package com.xzsd.pc.picture.service;
//Picture


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;

import com.xzsd.pc.picture.dao.PictureDao;
import com.xzsd.pc.picture.entity.PictureInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @DescriptionDemo 实现类
 * @Author dingning
 * @Date 2020-03-21
 */
@Service
public class PictureService {

    @Resource
    private PictureDao pictureDao;

    /**
     * demo 新增商品
     * @param pictureInfo
     * @return
     * @Author housum
     * @Date 2020-03-21
     */
    //回滚
    @Transactional(rollbackFor = Exception.class)
    public AppResponse savePicture(PictureInfo pictureInfo) {
        // 校验轮播图序号是否存在
        int countSortNo = pictureDao.countSortNo(pictureInfo);
        if(0 != countSortNo) {
            return AppResponse.bizError("序号已存在，请重新输入！");
        }
        pictureInfo.setBannerCode(StringUtil.getBannerCode(4));
        pictureInfo.setIsDeleted(0);
        pictureInfo.setPictureState(0);
        // 新增轮播图
        int count = pictureDao.savePicture(pictureInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * demo 删除轮播图
     * @param bannerCode
     * @param userCode
     * @return
     * @Author housum
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deletePicture(String bannerCode,String userCode) {
        List<String> listBannerCode = Arrays.asList(bannerCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除用户
        int count = pictureDao.deletePicture(listBannerCode,userCode);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * demo 查询商品列表（分页）
     * @param pictureInfo
     * @return
     * @Author housum
     * @Date 2020-03-25
     */
    public AppResponse listPicture(PictureInfo pictureInfo) {
        List<PictureInfo> pictureInfoList = pictureDao.listPictureByPage(pictureInfo);
        return AppResponse.success("查询成功！", getPageInfo(pictureInfoList));
    }


    /**
     * demo 启用轮播图
     * @param bannerCode
     * @param userCode
     * @return
     * @Author housum
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse pictureUpper(String bannerCode,String userCode,int version) {
        //选择的bannerCode放进一个list
        List<String> listBannerCode = Arrays.asList(bannerCode.split(","));
        AppResponse appResponse = AppResponse.success("启用成功！");
        // 修改为上架状态
        int count = pictureDao.pictureUpper(listBannerCode,userCode,version);
        if(0 == count) {
            appResponse = AppResponse.bizError("上架失败，请重试！");
        }
        return appResponse;
    }

    /**
     * demo 禁用轮播图
     * @param bannerCode
     * @param userCode
     * @return
     * @Author housum
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse pictureLower(String bannerCode,String userCode,int version) {
        //选择的bannerCode放进一个list
        List<String> listBannerCode2 = Arrays.asList(bannerCode.split(","));
        AppResponse appResponse = AppResponse.success("禁用成功！");
        // 修改为禁用状态
        int count = pictureDao.pictureLower(listBannerCode2,userCode,version);
        if(0 == count) {
            appResponse = AppResponse.bizError("禁用失败，请重试！");
        }
        return appResponse;
    }

}
