package com.xzsd.pc.classification.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;

import com.xzsd.pc.classification.dao.ClassificationDao;
import com.xzsd.pc.classification.entity.ClassificationInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @DescriptionDemo 实现类
 * @Author dingning
 * @Date 2020-03-21
 */
@Service
public class ClassificationService {

    @Resource
    private ClassificationDao classificationDao;

    /**
     * demo 新增父级分类
     * @param classificationInfo
     * @return
     * @Author housum
     * @Date 2020-03-21
     */
    //回滚
    @Transactional(rollbackFor = Exception.class)

    public AppResponse saveFatherCate(ClassificationInfo classificationInfo) {
        // 校验父级分类是否存在
        int countFatherCate = classificationDao.countFatherCate(classificationInfo);
        if(0 != countFatherCate) {
            return AppResponse.bizError("此分类已存在，请重新输入！");
        }
        classificationInfo.setCateCode(StringUtil.getCateCode());
        classificationInfo.setIsDeleted(0);
        classificationInfo.setIsParent(0);


        // 新增用户
        int count = classificationDao.saveFatherCate(classificationInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * demo 新增子级分类
     * @param classificationInfo
     * @return
     * @Author housum
     * @Date 2020-03-21
     */
    //回滚
    @Transactional(rollbackFor = Exception.class)

    public AppResponse saveSonCate(ClassificationInfo classificationInfo, @Param("cateCodeParent") String cateCodeParent) {
        // 校验子级分类是否存在
        int countSonCate = classificationDao.countSonCate(classificationInfo);
        if (0 != countSonCate) {
            return AppResponse.bizError("此分类已存在，请重新输入！");
        }
        classificationInfo.setCateCode(StringUtil.getCateCode());
        classificationInfo.setCateCodeParent(cateCodeParent);
        classificationInfo.setIsDeleted(0);
        classificationInfo.setIsParent(1);


        // 新增用户
        int count = classificationDao.saveSonCate(classificationInfo);
        if (0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        int count2 = classificationDao.saveSonCateParent(classificationInfo.getCateCode(),cateCodeParent);
        if (0 == count2) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");

    }


    /**
     * demo 查询分类列表
     * @param classificationInfo
     * @return
     * @Author housum
     * @Date 2020-03-21
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse listCate(ClassificationInfo classificationInfo) {


        List<ClassificationInfo> categories = classificationDao.listCateByPage(0);
//        List<CateListInfo> cateList2 = (List<CateListInfo>) new CateListInfo();
//        BeanUtils.copyProperties(categories, cateList2);

//        System.out.println("测试获取所有类别========》" + categories);

         //包装Page对象
//        PageInfo<ClassificationInfo> pageData = new PageInfo<ClassificationInfo>(categories);
        return AppResponse.success("查询成功！",getPageInfo(categories));
    }



    /**
     * demo 查询用分类详情
     * @param cateCode
     * @return
     * @Author housum
     * @Date 2020-03-21
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse getCateDetail(String cateCode) {
        ClassificationInfo classificationInfo = classificationDao.getCateDetail(cateCode);
        return AppResponse.success("查询成功！",classificationInfo);
    }

    /**
     * demo 删除分类  要判断是否是父类 父类的话 要把子类全部删除
     * @param cateCode
     * @param userCode
     * @return
     * @Author dingning
     * @Date 2020-03-21
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteCate(String cateCode,String userCode) {
        List<String> listCateCode = Arrays.asList(cateCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除用户
        int count = classificationDao.deleteCate(listCateCode,userCode);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }


}
