package com.xzsd.pc.top.dao;

import com.xzsd.pc.top.entity.TopInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TopDao {
    /**
     * 获取顶部栏信息
     * @param topInfo
     * @return
     */
    TopInfo getTopOfColumn(TopInfo topInfo);
}
