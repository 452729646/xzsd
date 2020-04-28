package com.xzsd.app.client.shoppingCart.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.client.shoppingCart.entity.ShoppingCartInfo;
import com.xzsd.app.client.shoppingCart.service.ShoppingCartService;
import org.apache.catalina.security.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description app客户端购物车增删查改
 * @Author housum
 * @Date 2020-4-17
 */
@RestController
@RequestMapping("/clientShopCart")
public class ShoppingCartController {
    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);
    @Resource
    ShoppingCartService shoppingCartService;

    /**
     * 新增购物车
     * @param shoppingCartInfo
     * @return
     */
    @PostMapping("addShoppingCart")
    public AppResponse saveShoppingCart(ShoppingCartInfo shoppingCartInfo){
        try{
            //获取用户编号
            String userCode = SecurityUtils.getCurrentUserId();
            shoppingCartInfo.setUserCode(userCode);
            return shoppingCartService.saveShoppingCart(shoppingCartInfo);
        }catch (Exception e){
            logger.error("新增购物车失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改购物车
     * @param shoppingCartInfo
     * @return App
     * @author housum
     * @date 2020-4-17
     */
    @PostMapping("updateShoppingCart")
    public AppResponse updateCart(ShoppingCartInfo shoppingCartInfo){
        try{
            //获取用户编号
            String userCode = SecurityUtils.getCurrentUserId();
            shoppingCartInfo.setUserCode(userCode);
            return shoppingCartService.updateCart(shoppingCartInfo);
        }catch (Exception e){
            logger.error("修改购物车失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除购物车的商品
     * @param shoppingCartInfo
     * @return
     * @author housum
     * @date 2020-4-17
     */
    @PostMapping("deleteShoppingCart")
    public AppResponse deleteCart(ShoppingCartInfo shoppingCartInfo){
        try{
            //获取用户编号
            String userCode = SecurityUtils.getCurrentUserId();
            shoppingCartInfo.setUserCode(userCode);
            return shoppingCartService.deleteCart(shoppingCartInfo);
        }catch (Exception e){
            logger.error("删除购物车失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    @PostMapping("listShoppingCarts")
    public AppResponse listCart(ShoppingCartInfo shoppingCartInfo){
        try {
            //获取用户编号
            String userCode = SecurityUtils.getCurrentUserId();
            shoppingCartInfo.setUserCode(userCode);
            return shoppingCartService.listCart(shoppingCartInfo);
        }catch (Exception e){
            logger.error("查询购物车列表失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
