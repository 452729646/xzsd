package com.xzsd.pc.classification.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;

import com.xzsd.pc.classification.dao.ClassificationDao;
import com.xzsd.pc.classification.entity.ClassificationInfo;
import com.xzsd.pc.classification.entity.OneClassifyInfo;
import com.xzsd.pc.classification.entity.OneClassifyListInfo;
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
        classificationInfo.setClassifyId(StringUtil.getCateCode());
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
        classificationInfo.setClassifyId(StringUtil.getCateCode());
        classificationInfo.setCateCodeParent(cateCodeParent);
        classificationInfo.setIsDeleted(0);
        classificationInfo.setIsParent(1);
        // 新增用户
        int countSaveSonCate = classificationDao.saveSonCate(classificationInfo);
        if (0 == countSaveSonCate) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        int countSaveSonCateParent = classificationDao.saveSonCateParent(classificationInfo.getClassifyId(),cateCodeParent);
        if (0 == countSaveSonCateParent) {
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
        List<OneClassifyInfo> categories = classificationDao.listCateByPage(0);
        OneClassifyListInfo oneClassifyListInfo = new OneClassifyListInfo();
        oneClassifyListInfo.setOneClassifyList(categories);
        return AppResponse.success("查询成功！",oneClassifyListInfo);
    }

    @Transactional(rollbackFor = Exception.class)
    public AppResponse listFatherCate(ClassificationInfo classificationInfo) {
        List<ClassificationInfo> categories = classificationDao.listFatherCateByPage(classificationInfo);
        return AppResponse.success("查询成功！",getPageInfo(categories));
    }

    @Transactional(rollbackFor = Exception.class)
    public AppResponse listSonCate(ClassificationInfo classificationInfo) {
        List<ClassificationInfo> categories = classificationDao.listSonCateByPage(classificationInfo);
        return AppResponse.success("查询成功！",getPageInfo(categories));
    }



    /**
     * demo 查询用分类详情
     * @param
     * @return
     * @Author housum
     * @Date 2020-03-21
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse getCateDetail(String classifyId) {
        ClassificationInfo classificationInfo = classificationDao.getCateDetail(classifyId);
        return AppResponse.success("查询成功！",classificationInfo);
    }

    /**
     * demo 删除分类  要判断是否是父类 父类的话 要把子类全部删除
     * @param
     * @param userCode
     * @return
     * @Author dingning
     * @Date 2020-03-21
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteCate(String classifyId,String userCode) {
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除用户
        int count = classificationDao.deleteCate(classifyId,userCode);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }


    /**
     * 修改分类信息
     * @param classificationInfo
     * @return
     *
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateCate(ClassificationInfo classificationInfo) {
        int countNameCate = classificationDao.countCateName(classificationInfo);
        if (0 != countNameCate) {
            return AppResponse.bizError("此分类已存在，请重新输入！");
        }
        // 删除用户
        int count = classificationDao.updateCate(classificationInfo);
        if(0 == count) {
            return AppResponse.bizError("修改失败，请重试！");
        }
        return  AppResponse.success("修改成功！");
    }


}
