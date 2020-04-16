package com.xzsd.app.client.goods.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.client.goods.dao.GoodsDao;
import com.xzsd.app.client.goods.entity.EvaluateInfo;
import com.xzsd.app.client.goods.entity.GoodsVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @DescriptionDemo 实现类
 * @Author housum
 * @Date 2020-04-16
 */
@Service
public class GoodsService {
    @Resource GoodsDao goodsDao;

    /**
     * 查询商品信息
     * @param skuNo
     *
     */
    public AppResponse goodsDetail(String skuNo){
        //查询出商品信息
        GoodsVO goodsDetail = goodsDao.goodsDetail(skuNo);
        //获取用户userCode
        String userCode = SecurityUtils.getCurrentUserId();
        //通过userCode查出所绑定的门店名称
        String storeName = goodsDao.selectStoreName(userCode);
        if ("".equals(storeName)||null == storeName){
            storeName = "您还没有绑定店铺邀请码";
        }
        //把storeName放进实体类
        goodsDetail.setStoreName(storeName);
        return AppResponse.success("查询成功",goodsDetail);
    }

    /**
     * 查询商品评价列表
     * @param evaluateInfo
     * @return
     */
    public AppResponse listEvaluateBySkuNo(EvaluateInfo evaluateInfo){
        List<EvaluateInfo> listEvaluateInfo = goodsDao.listEvaluateBySkuNoByPage(evaluateInfo);
        return AppResponse.success("查询成功",listEvaluateInfo);
    }
}
