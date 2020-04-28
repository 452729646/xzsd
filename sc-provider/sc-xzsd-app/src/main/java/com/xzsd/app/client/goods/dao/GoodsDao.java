package com.xzsd.app.client.goods.dao;

import com.xzsd.app.client.goods.entity.EvaluateInfo;
import com.xzsd.app.client.goods.entity.GoodsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName goodsDao
 * @Description
 * @Author housum
 * @Date 2020-04-16
 */
@Mapper
public interface GoodsDao {
    /**
     * 查询商品信息
     * @param skuNo
     * @return
     */
    GoodsVO goodsDetail(@Param("goodsId")String goodsId);

    /**
     * 通过userCode查出所绑定的门店名称
     * @param userCode
     * @return
     */
    String selectStoreName(@Param("userCode")String userCode);

    /**
     * 查询商品评价
     * @param evaluateInfo
     * @return
     */
    List<EvaluateInfo>listEvaluateBySkuNoByPage(EvaluateInfo evaluateInfo);
}
