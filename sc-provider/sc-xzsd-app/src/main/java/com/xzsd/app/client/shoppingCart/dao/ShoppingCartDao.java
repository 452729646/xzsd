package com.xzsd.app.client.shoppingCart.dao;

import com.xzsd.app.client.shoppingCart.entity.ShoppingCartInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName ShoppingCartDao
 * @Description
 * @Author housum
 * @Date 2020-04-17
 */
@Mapper
public interface ShoppingCartDao {
    /**
     * 检验该用户所选择的商品是否存在购物车
     * @param shoppingCartInfo
     * @return
     */
    int countGoods(ShoppingCartInfo shoppingCartInfo);

    /**
     * 新增购物车
     * @param shoppingCartInfo
     * @return
     */
    int saveShoppingCart(ShoppingCartInfo shoppingCartInfo);

    /**
     * 提取版本号
     * @param shoppingCartInfo
     * @return
     */
    int selectVersion(ShoppingCartInfo shoppingCartInfo);

    /**
     * 更新购物车的商品数量 在商品页面
     * @param shoppingCartInfo
     * @return
     */
    int updateCartInSave(ShoppingCartInfo shoppingCartInfo);

    /**
     * 更新购物车的商品数量 在购物车页面
     * @param shoppingCartInfo
     * @return
     */
    int updateCart(ShoppingCartInfo shoppingCartInfo);

    /**
     * 删除购物车
     * @param listShoppingCartCode
     * @param userCode
     * @return
     */
    int deleteCart(@Param("listShoppingCartCode")List<String> listShoppingCartCode,@Param("userCode")String userCode);

    /**
     * 查询购物车列表
     * @param shoppingCartInfo
     * @return
     */
    List<ShoppingCartInfo> listCartByPage(ShoppingCartInfo shoppingCartInfo);
}
