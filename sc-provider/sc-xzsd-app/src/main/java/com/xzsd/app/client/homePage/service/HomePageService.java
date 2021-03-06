package com.xzsd.app.client.homePage.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.client.homePage.dao.HomePageDao;
import com.xzsd.app.client.homePage.entity.ListHotGoodsInfo;
import com.xzsd.app.client.homePage.entity.ListInfo;
import com.xzsd.app.client.homePage.entity.PictureInfo;
import com.xzsd.app.client.homePage.entity.SlideshowListInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @DescriptionDemo 实现类
 * @Author housum
 * @Date 2020-04-13
 */
@Service
public class HomePageService {

    @Resource
    HomePageDao homePageDao;

    /**
     * 查询轮播图列表
     * @param pictureInfo
     * @author hosum
     * @date 2020-4-13
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse listPicture(PictureInfo pictureInfo){
        List<PictureInfo> pictureListInfo = homePageDao.listPictureByPage(pictureInfo);
        SlideshowListInfo slideshowListInfo = new SlideshowListInfo();
        slideshowListInfo.setSlideshowList(pictureListInfo);
        return AppResponse.success("查询成功！",slideshowListInfo);
    }

    /**
     * 查询热门列表
     * @param
     * @author hosum
     * @date 2020-4-13
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse listHotGoods(){
        //热门商品展示数量
        int displayCnt = homePageDao.selectDisplayCnt();
        List<ListHotGoodsInfo> hotGoodsListInfo = homePageDao.listHotGoods(displayCnt);
        ListInfo listInfo = new ListInfo();
        listInfo.setList(hotGoodsListInfo);
        return AppResponse.success("查询成功！",listInfo);
    }

}
