package com.xzsd.app.client.order.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.app.client.order.entity.OrderInfo;
import com.xzsd.app.client.order.dao.OrderDao;
import com.xzsd.app.client.order.entity.OrderVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @DescriptionDemo 实现类
 * @Author housum
 * @Date 2020-04-9
 */
@Service
public class OrderService {
    @Resource
    private OrderDao orderDao;






    /**
     * 新增订单
     * @param orderInfo
     * @return
     * @author housum
     * @date 2020-4-9
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveOrder(OrderInfo orderInfo, String skuNo2, String goodsCnt, String sellingMoney) {
        List<String> listGoodsCnt = Arrays.asList(goodsCnt.split(","));

        List<String> listSellingMoney = Arrays.asList(sellingMoney.split(","));



        List<String> listSkuNo = Arrays.asList(skuNo2.split(","));


        //算出这个订单的总价
        BigDecimal sum = new BigDecimal("0");
//        用于计算该订单的物品总数量
        BigDecimal total = new BigDecimal("0");
        for (int i = 0; i < listSkuNo.size(); i++) {
            BigDecimal a = new BigDecimal(listGoodsCnt.get(i)).multiply(new BigDecimal(listSellingMoney.get(i)));
            total = total.add(new BigDecimal(listGoodsCnt.get(i)));
            sum = sum.add(a);
        }
        String orderId = StringUtil.getCommonCode(6);
        String userCode = orderInfo.getUserCode();

        int count = orderDao.saveOrderFather(orderInfo, orderId, sum, userCode,total);
        for (int i = 0; i < listSkuNo.size(); i++) {
            String skuNo = listSkuNo.get(i);
            String goodsCnt2 = listGoodsCnt.get(i);
            String sellingPrice = listSellingMoney.get(i);
            BigDecimal totalPrice = new BigDecimal(listGoodsCnt.get(i)).multiply(new BigDecimal(listSellingMoney.get(i)));
            int count2 = orderDao.saveOrderSon(orderId, skuNo, goodsCnt2, sellingPrice, totalPrice,userCode);
            if (count2 == 0) {
                return AppResponse.bizError("新增失败，请重试！");
            }
        }
        if (count == 0) {
            return AppResponse.bizError("新增失败，请重试！");

        }
        return AppResponse.success("新增成功！");



    }

    /**
     * 查询该用户的订单列表
     * @param orderVO
     * @author housum
     * @date 2020-4-14
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse listOrderByUserCode(OrderVO orderVO) {
        List<OrderVO> listInfoOrder = orderDao.listOrderByUserCode(orderVO);
        return AppResponse.success("查询成功", listInfoOrder);
    }


}
