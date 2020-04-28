package com.xzsd.app.client.shoppingCart.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.app.client.shoppingCart.dao.ShoppingCartDao;
import com.xzsd.app.client.shoppingCart.entity.ShoppingCartInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @DescriptionDemo 实现类
 * @Author housum
 * @Date 2020-04-17
 */
@Service
public class ShoppingCartService {
    @Resource
    ShoppingCartDao shoppingCartDao;

    /**
     * 新增购物车
     * @param shoppingCartInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveShoppingCart(ShoppingCartInfo shoppingCartInfo){
        //检验该用户所选择的商品是否存在购物车
        int countGoods = shoppingCartDao.countGoods(shoppingCartInfo);
        if (0 != countGoods){
//            //获取version
//            int version = shoppingCartDao.selectVersion(shoppingCartInfo);
//            shoppingCartInfo.setVersion(version);
            //说明购物车已存在该商品 应该是修改商品数量
            int countUpdateCart = shoppingCartDao.updateCartInSave(shoppingCartInfo);
            if (0 == countUpdateCart){
                return AppResponse.bizError("新增购物车失败");
            }
            return AppResponse.success("新增购物车成功");
        }
        shoppingCartInfo.setShopCartId(StringUtil.getCommonCode(6));
        shoppingCartInfo.setIsDeleted(0);
        //新增购物车
        int count = shoppingCartDao.saveShoppingCart(shoppingCartInfo);
        if (0 == count){
            return AppResponse.bizError("新增购物车失败");
        }
        return AppResponse.success("新增购物车成功");
    }

    /**
     * 修改购物车
     * @param shoppingCartInfo
     * @return
     * @author housum
     * @date 2020-4-17
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateCart(ShoppingCartInfo shoppingCartInfo){
        //获取version
        int version = shoppingCartDao.selectVersion(shoppingCartInfo);
        shoppingCartInfo.setVersion(version);
        //修改购物车
        int countUpdateCart = shoppingCartDao.updateCart(shoppingCartInfo);
        if (0 == countUpdateCart){
            return AppResponse.bizError("修改购物车失败，请重试");
        }
        return AppResponse.success("修改购物车成功");
    }

    /**
     * 删除购物车
     * @param shoppingCartInfo
     * @return
     * @author housum
     * @date 2020-4-17
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteCart(ShoppingCartInfo shoppingCartInfo){
        //选择多个购物车商品code 放进一个list
        List<String> listShoppingCartCode = Arrays.asList(shoppingCartInfo.getShopCartId().split(","));
        //获取userCode
        String userCode = shoppingCartInfo.getUserCode();
        int count = shoppingCartDao.deleteCart(listShoppingCartCode,userCode);
        if (0 == count){
            return AppResponse.bizError("删除失败，请重试");
        }
        return AppResponse.success("删除成功");
    }

    /**
     * 查询购物车列表
     * @param shoppingCartInfo
     * @return
     */
    public AppResponse listCart(ShoppingCartInfo shoppingCartInfo){
        List<ShoppingCartInfo> cartInfoList = shoppingCartDao.listCartByPage(shoppingCartInfo);
        return AppResponse.success("查询成功",getPageInfo(cartInfoList));
    }
}
