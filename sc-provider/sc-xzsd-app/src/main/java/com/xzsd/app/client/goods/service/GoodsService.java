package com.xzsd.app.client.goods.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.client.commodityClassification.dao.CommodityClassificationDao;
import com.xzsd.app.client.commodityClassification.entity.CommodityClassificationInfo;
import com.xzsd.app.client.commodityClassification.entity.ListSonCateGoodsInfo;
import com.xzsd.app.client.goods.dao.GoodsDao;
import com.xzsd.app.client.goods.entity.EvaluateInfo;
import com.xzsd.app.client.goods.entity.GoodsVO;
import com.xzsd.app.client.goods.entity.ListFatherCateInfo;
import com.xzsd.app.client.goods.entity.ListGoodsSonCateInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @DescriptionDemo 实现类
 * @Author housum
 * @Date 2020-04-16
 */
@Service
public class GoodsService {
    @Resource GoodsDao goodsDao;
    @Resource CommodityClassificationDao commodityClassificationDao;

    /**
     * 查询商品信息
     * @param
     *
     */
    public AppResponse goodsDetail(String goodsId){
        //查询出商品信息
        GoodsVO goodsDetail = goodsDao.goodsDetail(goodsId);
//        //获取用户userCode
//        String userCode = SecurityUtils.getCurrentUserId();
//        //通过userCode查出所绑定的门店名称
//        String storeName = goodsDao.selectStoreName(userCode);
//        if ("".equals(storeName)||null == storeName){
//            storeName = "您还没有绑定店铺邀请码";
//        }
//        //把storeName放进实体类
//        goodsDetail.setStoreName(storeName);
        return AppResponse.success("查询成功",goodsDetail);
    }

    /**
     * 查询商品评价列表
     * @param evaluateInfo
     * @return
     */
    public AppResponse listEvaluateBySkuNo(EvaluateInfo evaluateInfo){
        List<EvaluateInfo> listEvaluateInfo = goodsDao.listEvaluateBySkuNoByPage(evaluateInfo);
        //加密 隐藏客户账号的几个字符
        for (int j = 0 ; j < listEvaluateInfo.size(); j++) {
            char[] cs = listEvaluateInfo.get(j).getUserAcct().toCharArray();
            for(int i = cs.length - 1, d = 0; i>= 0 && d < 4; --i){
                if (Character.isDigit(cs[i])){
                    cs[i] = '*';
                    ++d;
                }
            }
            listEvaluateInfo.get(j).setUserAcct(String.valueOf(cs));
        }
        return AppResponse.success("查询成功",getPageInfo(listEvaluateInfo));
    }

    /**
     * 查询父分类列表
     *
     * @param
     * @return
     * @Author housum
     * @Date 2020-04-13
     */
    public AppResponse listFatherCate(){
        List<CommodityClassificationInfo> fatherCateInfoList = commodityClassificationDao.listFatherCateByPage();
        ListFatherCateInfo listFatherCateInfo = new ListFatherCateInfo();
        listFatherCateInfo.setOneClassifyList(fatherCateInfoList);
        return AppResponse.success("查询成功！",listFatherCateInfo);
    }

    /**
     * 查询子分类商品
     * @return AppResponse
     * @param listSonCateGoodsInfo
     * @author housum
     * @date 2020-4-14
     */

    public AppResponse listSonCateGoods(ListSonCateGoodsInfo listSonCateGoodsInfo){
        List<ListSonCateGoodsInfo> listSonCateGoodsInfoList = commodityClassificationDao.listSonCateGoodsByPage(listSonCateGoodsInfo);
        ListGoodsSonCateInfo listGoodsSonCateInfo = new ListGoodsSonCateInfo();
        listGoodsSonCateInfo.setTwoClassifyList(listSonCateGoodsInfoList);
        return AppResponse.success("查询成功",listGoodsSonCateInfo);
    }
}
