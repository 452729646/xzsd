package com.xzsd.pc.hotgoods.dao;



import com.xzsd.pc.goods.entity.GoodListInfo;
import com.xzsd.pc.hotgoods.entity.HotGoodsInfo;
import com.xzsd.pc.hotgoods.entity.HotGoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName hotGoodsDao
 * @Description
 * @Author housum
 * @Date 2020-03-27
 */
@Mapper
public interface HotGoodsDao {
    /**
     * 统计热门排序号数量
     * @param hotGoodsInfo 用户信息
     * @return
     */
    int countSortNo(HotGoodsInfo hotGoodsInfo);

    /**
     * 新增商品
     * @param hotGoodsInfo 商品信息
     * @return
     */
    int saveHotGoods(HotGoodsInfo hotGoodsInfo);

    /**
     * 获取所有商品信息
     * @param goodListInfo 用户信息
     * @return 所有用户信息
     */
    List<GoodListInfo> hotListGoodsByPage(GoodListInfo goodListInfo);

    /**
     * 获取所有热门商品的信息
     * @param hotGoodsVo
     * @return 所有热门商品信息
     */
    List<HotGoodsVo> hotGoodsListByPage(HotGoodsVo hotGoodsVo);

    /**
     * 修改该热门商品信息
     * @param hotGoodsInfo
     * @return
     */
    int updateHotGoods(HotGoodsInfo hotGoodsInfo);

    /**
     * 删除热门商品
     * @param hotGoodsCodeList 选中的热门商品Code集合
     * @param userCode 更新人
     */
    int deleteHotGoods( @Param("hotGoodsCodeList")List<String> hotGoodsCodeList, @Param("userCode") String userCode);

    /**
     * 设置展示数量
     * @param version
     * @param userCode
     * @param displayCnt
     */
    int setDisplayCnt(@Param("hotGoodsShowNum")int hotGoodsShowNum,@Param("userCode")String userCode,@Param("version")int version);

    /**
     * 查询展示数量
     * @param hotGoodsVo

     */
    HotGoodsVo selectDisplayCnt(HotGoodsVo hotGoodsVo);

    HotGoodsVo getHotGoods(HotGoodsVo hotGoodsVo);
}
