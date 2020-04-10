package com.xzsd.pc.goods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;

import com.xzsd.pc.goods.dao.GoodsDao;
import com.xzsd.pc.goods.entity.GoodsInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

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
        goodsInfo.setSkuNo(StringUtil.getSkuNo(4));
        goodsInfo.setIsDeleted(0);
        goodsInfo.setSkuState(0);
        goodsInfo.setSaleCnt(0);
        // 新增用户
        int count = goodsDao.saveGoods(goodsInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        //发送queue

//        String json = JsonUtils.toJson(goodsInfo);
//
//        this.sendMessage(this.queue,goodsInfo);
        return AppResponse.success("新增成功！");

    }


//    // 发送消息，destination是发送到的队列，message是待发送的消息
//    private void sendMessage(Destination destination, Object message) {
//
//        jmsMessagingTemplate.convertAndSend(destination, message);
//    }


    /**
     * demo 删除商品
     * @param skuNo
     * @param userCode
     * @return
     * @Author dingning
     * @Date 2020-03-21
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoods(String skuNo,String userCode) {
        List<String> listSkuNo = Arrays.asList(skuNo.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除用户
        int count = goodsDao.deleteGoods(listSkuNo,userCode);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
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
//        PageHelper.startPage(goodsInfo.getPageNum(), goodsInfo.getPageSize());
        List<GoodsInfo> goodsInfoList = goodsDao.listGoodsByPage(goodsInfo);
//         包装Page对象
//        PageInfo<GoodsInfo> pageData = new PageInfo<GoodsInfo>(goodsInfoList);
        //直接查询
        return AppResponse.success("查询成功！", getPageInfo(goodsInfoList));

//        //从Redis查询，将pageDate转换为json格式
//        String json = JsonUtils.toJson(pageData);
//
//        System.out.println(redisOperator.get("GoodsTest") );
//        System.out.println(json);
//        if (redisOperator.hasKey("GoodsTest")){
//            String json2 = redisOperator.get("GoodsTest");
//            if (json.equals(json2)) {
//                PageInfo result = JsonUtils.fromJson(redisOperator.get("GoodsTest"), PageInfo.class);
//                return AppResponse.success("存在key，查询成功", result);
//            }else{
//                redisOperator.set("GoodsTest",json,300);
//                PageInfo result = JsonUtils.fromJson(redisOperator.get("GoodsTest"),PageInfo.class);
//                return AppResponse.success("上传redis————————查询成功！",result);
//            }
//        }else{
//            redisOperator.set("GoodsTest",json,300);
//            PageInfo result = JsonUtils.fromJson(redisOperator.get("GoodsTest"),PageInfo.class);
//            return AppResponse.success("上传redis————————查询成功！",result);
//        }


//        redisOperator.get("GoodsTest");

//        List<PageInfo> pageDate = JSON.parseObject(json,new TypeReference<List<PageInfo>>(){});
//        List<PageInfo> pageDate2 = JSON.parseArray(redisOperator.get("GoodsTest"),PageInfo.class);




//        return AppResponse.success("查询成功！",result);
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
    public AppResponse goodsUpper(String skuNo,String userCode,int version) {
        //选择的skuNo放进一个list
        List<String> listSkuNo2 = Arrays.asList(skuNo.split(","));
        AppResponse appResponse = AppResponse.success("上架成功！");
        // 修改为上架状态
        int count = goodsDao.goodsUpper(listSkuNo2,userCode,version);
        if(0 == count) {
            appResponse = AppResponse.bizError("上架失败，请重试！");
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
        // 修改为上架状态
        int count = goodsDao.goodsLower(listSkuNo3,userCode,version);
        if(0 == count) {
            appResponse = AppResponse.bizError("下架失败，请重试！");
        }
        return appResponse;
    }

}
