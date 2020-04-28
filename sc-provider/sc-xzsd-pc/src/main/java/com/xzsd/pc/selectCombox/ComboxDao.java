package com.xzsd.pc.selectCombox;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ComboxDao {
    List<RegionInfo> listArea(RegionInfo regionInfo);
}
