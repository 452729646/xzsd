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
    private String imageUrl;
    /**
     * 排序
     */
    private int sortNo;
    /**
     * 对应的skuNo
     */
    private String skuNo;

    public String getBannerCode() {
        return bannerCode;
    }

    public void setBannerCode(String bannerCode) {
        this.bannerCode = bannerCode;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getSortNo() {
        return sortNo;
    }

    public void setSortNo(int sortNo) {
        this.sortNo = sortNo;
    }

    public String getSkuNo() {
        return skuNo;
    }

    public void setSkuNo(String skuNo) {
        this.skuNo = skuNo;
    }
}
