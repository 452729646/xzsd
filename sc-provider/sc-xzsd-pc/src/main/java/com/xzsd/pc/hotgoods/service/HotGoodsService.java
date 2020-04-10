package com.xzsd.pc.hotgoods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;

import com.xzsd.pc.goods.dao.GoodsDao;
import com.xzsd.pc.goods.entity.GoodListInfo;
import com.xzsd.pc.hotgoods.dao.HotGoodsDao;
import com.xzsd.pc.hotgoods.entity.HotGoodsInfo;
import com.xzsd.pc.hotgoods.entity.HotGoodsVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @DescriptionDemo 实现类
 * @Author housum
 * @Date 2020-03-27
 */
@Service
public class HotGoodsService {

    @Resource
    private HotGoodsDao hotGoodsDao;
    private GoodsDao goodsDao;

    /**
     * demo 新增热门商品
     * @param hotGoodsInfo
     * @return
     * @Author housum
     * @Date 2020-03-21
     */
//回滚
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveHotGoods(HotGoodsInfo hotGoodsInfo) {
        // 校验热门排序号是否存在
        int countSortNo = hotGoodsDao.countSortNo(hotGoodsInfo);
        if(0 != countSortNo) {
            return AppResponse.bizError("热门排序号已存在，请重新输入！");
        }
        hotGoodsInfo.setHotGoodsCode(StringUtil.getHotGoodsCode());
        hotGoodsInfo.setIsDeleted(0);

        // 新增热门商品
        int count = hotGoodsDao.saveHotGoods(hotGoodsInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * demo 新赠热门商品的商品列表
     * @param goodListInfo
     * @return
     * @Author housum
     * @Date 2020-03-21
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse hotListGoods(GoodListInfo goodListInfo) {

        List<GoodListInfo> goodsInfoList = hotGoodsDao.hotListGoodsByPage(goodListInfo);

        return AppResponse.success("查询成功！",goodsInfoList);
    }

    /**
     * 查询热门商品列表
     * @author housum
     * @Date 2020-3-27
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse hotGoodsList(HotGoodsVo hotGoodsVo){
//        PageHelper.startPage(hotGoodsVo.getPageNum(),hotGoodsVo.getPageSize());
        List<HotGoodsVo> hotGoodsVosList = hotGoodsDao.hotGoodsListByPage(hotGoodsVo);
//        PageInfo<HotGoodsVo> pageData = new PageInfo<HotGoodsVo>(hotGoodsVosList);
        return AppResponse.success("查询成功！",getPageInfo(hotGoodsVosList));
    }

    /**
     * 修改热门商品信息
     * @author housum
     * @date 2020-3-27
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateHotGoods(HotGoodsInfo hotGoodsInfo){
        AppResponse appResponse = AppResponse.success("修改成功");
        int countSortNo = hotGoodsDao.countSortNo(hotGoodsInfo);
        if(0 != countSortNo) {
            return AppResponse.bizError("热门排序号已存在，请重新输入！");
        }
        int count = hotGoodsDao.updateHotGoods(hotGoodsInfo);
        if (0 == count){
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * 删除热门商品
     * @author housum
     * @date 2020-3-27
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteHotGoods(String hotGoodsCode,String userCode){
        List<String> hotGoodsCodeList = Arrays.asList(hotGoodsCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功");
        int count = hotGoodsDao.deleteHotGoods(hotGoodsCodeList,userCode);
        if (0 == count){
            appResponse = AppResponse.bizError("删除失败，请重试");
        }
        return appResponse;

    }

}
