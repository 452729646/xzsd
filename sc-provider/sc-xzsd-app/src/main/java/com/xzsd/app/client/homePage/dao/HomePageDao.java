package com.xzsd.app.client.homePage.dao;

import com.xzsd.app.client.homePage.entity.ListHotGoodsInfo;
import com.xzsd.app.client.homePage.entity.PictureInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @ClassName homePageDao
 * @Description
 * @Author housum
 * @Date 2020-04-13
 */
@Mapper
public interface HomePageDao {
    /**
     * 查询轮播图列表
     * @param pictureInfo
     * @author housum
     * @date 2020-4-13
     */
    List<PictureInfo> listPicture(PictureInfo pictureInfo);

    /**
     * 查询热门商品展示数量
     * @return
     */
    int selectDisplayCnt();

    /**
     * 查询热门商品列表
     * @param listHotGoodsInfo
     * @param displayCnt
     * @author housum
     * @date 2020-4-13
     */
    List<ListHotGoodsInfo> listHotGoods(@Param("displayCnt")int displayCnt);

}
