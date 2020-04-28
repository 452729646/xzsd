package com.xzsd.pc.goods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;

import com.xzsd.pc.goods.dao.GoodsDao;
import com.xzsd.pc.goods.entity.ClassifyInfo;
import com.xzsd.pc.goods.entity.GoodsClassifyList;
import com.xzsd.pc.goods.entity.GoodsInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

import static com.neusoft.core.page.PageUtils.getPageInfo;


/**
 * @DescriptionDemo 实现类
 * @Author housum
 * @Date 2020-03-21
 */
@Service
public class GoodsService {



    @Resource
    private GoodsDao goodsDao;
//    @Resource
//    private RedisService redisService;
//    @Autowired
//    RedisOperator redisOperator;
//    private RedisTemplate<String ,Object> redisTemplate;
//
//    @Autowired
//    private JmsMessagingTemplate jmsMessagingTemplate;
//
//    @Autowired
//    private Queue queue;


    /**
     * demo 新增商品
     * @param goodsInfo
     * @return
     * @Author housum
     * @Date 2020-03-21
     */
    //回滚
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveGoods(GoodsInfo goodsInfo) {
        // 校验商品书号是否存在
        int countBookNumber = goodsDao.countBookNumber(goodsInfo);
        if(0 != countBookNumber) {
            return AppResponse.bizError("书号已存在，请重新输入！");
        }
        goodsInfo.setGoodsId(StringUtil.getSkuNo(4));
        goodsInfo.setIsDeleted(0);
        goodsInfo.setGoodsStateId("3");
        goodsInfo.setGoodsSales(0);
        // 新增用户
        int count = goodsDao.saveGoods(goodsInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }





    /**
     * demo 删除商品
     * @param skuNo
     * @param userCode
     * @return
     * @Author dingning
     * @Date 2020-03-21
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoods(String goodsId,String userCode) {
        List<String> listSkuNo = Arrays.asList(goodsId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        int countInSelling = goodsDao.countInSelling(listSkuNo);
        if (0 != countInSelling){
            return AppResponse.bizError("选择的商品仍在上架中，无法删除");
        }
        // 删除用户
        int count = goodsDao.deleteGoods(listSkuNo,userCode);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除，请重试！");
        }
        return appResponse;
    }


    /**
     * demo 修改商品
     * @param goodsInfo
     * @return
     * @Author dingning
     * @Date 2020-03-21
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoods(GoodsInfo goodsInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验书号是否存在
        int countBookNumber = goodsDao.countBookNumber(goodsInfo);
        if (0 != countBookNumber) {
            return AppResponse.bizError("书号已存在，请重新输入！");
        }
        // 修改商品信息
        int count = goodsDao.updateGoods(goodsInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }
    /**
     * demo 查询商品列表（分页）
     * @param goodsInfo
     * @return
     * @Author dingning
     * @Date 2020-03-21
     */
    public AppResponse listGoods(GoodsInfo goodsInfo) {
        List<GoodsInfo> goodsInfoList = goodsDao.listGoodsByPage(goodsInfo);
        return AppResponse.success("查询成功！", getPageInfo(goodsInfoList));
    }



    /**
     * demo 上架商品
     * @param skuNo
     * @param userCode
     * @return
     * @Author housum
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse goodsUpper(GoodsInfo goodsInfo) {
        //选择的skuNo放进一个list
        List<String> listSkuNo2 = Arrays.asList(goodsInfo.getGoodsId().split(","));
        List<String> listVersion = Arrays.asList(goodsInfo.getVersion().split(","));
        String goodsStateId = goodsInfo.getGoodsStateId();
        String userCode = goodsInfo.getUserId();
        List<Map> mapList = new ArrayList<>();
        for(int i =0 ;i<listSkuNo2.size(); i++){
            Map map = new HashMap();
            map.put("goodsId",listSkuNo2.get(i));
            map.put("version",listVersion.get(i));
            map.put("userCode",userCode);
            map.put("goodsStateId",goodsStateId);
            mapList.add(map);
        }
        AppResponse appResponse = AppResponse.success("修改成功！");
//        下架需要检验
        if ("2".equals(goodsStateId)){
            int countInHotGoods = goodsDao.countInHotGoods(listSkuNo2);
            if (0 != countInHotGoods){
                return AppResponse.bizError("选择的商品存在于热门商品，无法下架");
            }
            int countInBanner = goodsDao.countInBanner(listSkuNo2);
            if (0 != countInBanner){
                return AppResponse.bizError("选择的商品存在于轮播图，处于启动中，无法下架");
            }
        }
        // 修改为上架状态
        int count = goodsDao.goodsUpper(mapList);
        if(0 == count) {
            appResponse = AppResponse.bizError("修改失败，请重试！");
        }
        return appResponse;
    }

    /**
     *  下架商品
     * @param skuNo
     * @param userCode
     * @return
     * @Author housum
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse goodsLower(String skuNo,String userCode,int version) {
        //选择的skuNo放进一个list
        List<String> listSkuNo3 = Arrays.asList(skuNo.split(","));
        AppResponse appResponse = AppResponse.success("下架成功！");
        int countInHotGoods = goodsDao.countInHotGoods(listSkuNo3);
        if (0 != countInHotGoods){
            return AppResponse.bizError("选择的商品存在于热门商品，无法下架");
        }
        int countInBanner = goodsDao.countInBanner(listSkuNo3);
        if (0 != countInBanner){
            return AppResponse.bizError("选择的商品存在于轮播图，处于启动中，无法下架");
        }
//        // 修改为上架状态
        int count = goodsDao.goodsLower(listSkuNo3,userCode,version);
        if(0 == count) {
            appResponse = AppResponse.bizError("下架失败，请重试！");
        }
        return appResponse;
    }

    public AppResponse listGoodsClassify(String classifyId){
        List<ClassifyInfo> classifyInfos = goodsDao.listGoodsClassify(classifyId);
        GoodsClassifyList goodsClassifyList = new GoodsClassifyList();
        goodsClassifyList.setGoodsClassifyList(classifyInfos);
        return AppResponse.success("查询成功",goodsClassifyList);
    }

    public AppResponse getGoods(String goodsId){
        GoodsInfo data = goodsDao.getGoods(goodsId);
        return AppResponse.success("查询成功",data);
    }

}
