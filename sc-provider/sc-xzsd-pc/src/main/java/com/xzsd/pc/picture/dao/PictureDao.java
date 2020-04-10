package com.xzsd.pc.picture.dao;



import com.xzsd.pc.picture.entity.PictureInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PictureDao {
    /**
     * 统计该序号数量
     * @param PictureInfo 轮播图信息
     * @return
     */
    int countSortNo(PictureInfo PictureInfo);

    /**
     * 新增轮播图
     * @param pictureInfo 轮播图信息
     * @return
     */
    int savePicture(PictureInfo pictureInfo);

    /**
     * 删除轮播图信息
     * @param listBannerCode 选中的轮播图编号集合
     * @param userCode 更新人
     * @return
     */
    int deletePicture(@Param("listBannerCode")List<String> listBannerCode, @Param("userCode") String userCode);


    /**
     * 获取所有轮播图信息
     * @param pictureInfo 用户信息
     * @return 所有用户信息
     */
    List<PictureInfo> listPictureByPage(PictureInfo pictureInfo);

    /**
     * 启用轮播图
     * @param listBannerCode 选中的轮播图编号集合
     * @param userCode 更新人
     * @return
     */
    int pictureUpper(@Param("listBannerCode")List<String> listBannerCode, @Param("userCode") String userCode, @Param("version") int version);

    /**
     * 禁用轮播图
     * @param listBannerCode2 选中的轮播图编号集合
     * @param userCode 更新人
     * @return
     */
    int pictureLower(@Param("listBannerCode2")List<String> listBannerCode2, @Param("userCode") String userCode, @Param("version") int version);
}
