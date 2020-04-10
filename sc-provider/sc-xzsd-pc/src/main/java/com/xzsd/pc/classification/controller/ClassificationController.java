package com.xzsd.pc.classification.controller;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;

import com.xzsd.pc.classification.entity.ClassificationInfo;
import com.xzsd.pc.classification.service.ClassificationService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 商品分类增删查改
 * @Author housum
 * @Date 2020-03-25
 */
@RestController
@RequestMapping("/classification")
public class ClassificationController {

    private static final Logger logger = LoggerFactory.getLogger(ClassificationController.class);

    @Resource
    private ClassificationService classificationService;


    /**
     * demo 新增父类分类
     * @param
     * @return AppResponse
     * @author housum
     * @Date 2020-03-24
     */

    @PostMapping("saveFatherCate")
    public AppResponse saveFatherCate(ClassificationInfo classificationInfo) {
        try {
            //获取用户id
            String userCode = SecurityUtils.getCurrentUserId();
            classificationInfo.setCreateBy(userCode);
            AppResponse appResponse = classificationService.saveFatherCate(classificationInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("分类新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 新增子类
     * @param  classificationInfo
     * @return AppResponse
     * @author housum
     * @Date 2020-03-25
     */
    @PostMapping("saveSonCate")
    public AppResponse saveSonCate(ClassificationInfo classificationInfo, @Param("cateCodeParent") String cateCodeParent) {
        try {
            //获取用户id
            String userCode = SecurityUtils.getCurrentUserId();
            classificationInfo.setCreateBy(userCode);
            AppResponse appResponse = classificationService.saveSonCate(classificationInfo,cateCodeParent);
            return appResponse;
        } catch (Exception e) {
            logger.error("分类新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * demo 分类列表
     * @param classificationInfo
     * @author housum
     * @Date 2020-03-25
     */
    @RequestMapping(value = "listCate")
    public AppResponse listCate(ClassificationInfo classificationInfo) {
        try {

            return classificationService.listCate(classificationInfo);
        } catch (Exception e) {
            logger.error("查询分类列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }




//        for (ClassificationInfo c : categories
//        ) {
//            System.out.println(c.getCateName());
//            List<ClassificationInfo> childs = c.getClassificationSonList();
//            for (ClassificationInfo c1 : childs
//            ) {
//                System.out.println(c1.getCateName());
//            }
//
//        }


//    /**
//     * demo 查询分类详情
//     * @param cateCode
//     * @return AppResponse
//     * @author dingning
//     * @Date 2020-03-21
//     */
//    @RequestMapping(value = "insertCateDetail")
//    public AppResponse insertCateDetail(String cateCode) {
//        try {
//            return classificationService.insertCateDetail(cateCode);
//        } catch (Exception e) {
//            logger.error("分类详情查询错误", e);
//            System.out.println(e.toString());
//            throw e;
//        }
//    }

    /**
     * demo 查询分类详情
     * @param cateCode
     * @return AppResponse
     * @author housum
     * @Date 2020-03-26
     */
    @RequestMapping(value = "getCateDetail")
    public AppResponse getCateDetail(String cateCode) {
        try {
            return classificationService.getCateDetail(cateCode);
        } catch (Exception e) {
            logger.error("用户查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *  删除分类
     * @param
     * @return AppResponse
     * @author housum
     * @Date 2020-03-26
     */
    @PostMapping("deleteCate")
    public AppResponse deleteCate(String cateCode) {
        try {
            //获取用户id
            String userCode = SecurityUtils.getCurrentUserId();
            return classificationService.deleteCate(cateCode,userCode);
        } catch (Exception e) {
            logger.error("分类删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}






