package com.xzsd.app.client.homePage.entity;

/**
 * 主页轮播图
 * @author housum
 * @date 2020-4-13
 */
public class PictureInfo {
    /**
     * 轮播图编码
     */
    private String bannerCode;
    /**
     * 图片连接
     */
    private String slideshowPath;
    /**
     * 排序
     */
    private int sortNo;
    /**
     * 对应的skuNo
     */
    private String goodsId;

    public String getBannerCode() {
        return bannerCode;
    }

    public void setBannerCode(String bannerCode) {
        this.bannerCode = bannerCode;
    }



    public int getSortNo() {
        return sortNo;
    }

    public void setSortNo(int sortNo) {
        this.sortNo = sortNo;
    }

    public String getSlideshowPath() {
        return slideshowPath;
    }

    public void setSlideshowPath(String slideshowPath) {
        this.slideshowPath = slideshowPath;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }
}
