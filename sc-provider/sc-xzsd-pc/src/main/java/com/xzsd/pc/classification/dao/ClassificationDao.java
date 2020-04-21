package com.xzsd.pc.classification.dao;


import com.xzsd.pc.classification.entity.ClassificationInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClassificationDao {

    /**
     * 统计父级分类数量
     * @param classificationInfo 分类信息
     * @return
     */
    int countFatherCate(ClassificationInfo classificationInfo);

    /**
     * 新增父级分类
     * @param classificationInfo 商品信息
     * @return
     */
    int saveFatherCate(ClassificationInfo classificationInfo);

    /**
     * 统计子级分类数量
     * @param classificationInfo 分类信息
     * @return
     */
    int countSonCate(ClassificationInfo classificationInfo);

    /**
     * 新增子级分类
     * @param classificationInfo 商品信息
     * @return
     */
    int saveSonCate(ClassificationInfo classificationInfo);

    /**
     * 新增子级分类的父类编码
     * @param cateCode 该子类的编码
     * @return
     */
    int saveSonCateParent(@Param("cateCode")String cateCode, @Param("cateCodeParent")String cateCodeParent);

    /**
     *父级分类
     * @param classificationInfo 分类信息
     * @return 信息
     */
    List<ClassificationInfo>listFatherCateByPage(ClassificationInfo classificationInfo);
    List<ClassificationInfo>listSonCateByPage(ClassificationInfo classificationInfo);
    /**
     *通过是否父级 拿出父级
     * @param classificationInfo 分类信息
     * @return 信息
     */
    List<ClassificationInfo>getByIsParent(ClassificationInfo classificationInfo);

    //查看所有类别（id=0）（或指定类别下所有子类别）


     List<ClassificationInfo> listCateByPage(@Param("isParent") int isParent);



    /**
     * 查询分类信息
     * @param cateCode 用户编号
     * @return 修改结果
     */
    ClassificationInfo getCateDetail(@Param("cateCode") String cateCode);


    /**
     * 删除商品信息
     * @param listCateCode 选中的用户编号集合
     * @param userCode 更新人
     * @return
     */
    int deleteCate(@Param("listCateCode")List<String> listCateCode, @Param("userCode") String userCode);

    /**
     * 查看是否有重名
     * @param classificationInfo
     * @return
     */
    int countCateName(ClassificationInfo classificationInfo);

    /**
     * 修改分类信息
     * @param classificationInfo
     * @return
     */
    int updateCate(ClassificationInfo classificationInfo);
}
