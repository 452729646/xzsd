package com.xzsd.pc.selectCombox;

import com.neusoft.core.restful.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @DescriptionDemo 实现类
 * @Author housum
 * @Date 2020-04-25
 */
@Service
public class ComboxService {
    @Resource ComboxDao comboxDao;

    /**
     * 地区下拉框
     * @param regionInfo
     * @return
     */
    public AppResponse listArea(RegionInfo regionInfo){
        //省的下拉表
        if ("0".equals(regionInfo.getAreaId())){
            regionInfo.setAreaId("100000");
        }
        List<RegionInfo> data = comboxDao.listArea(regionInfo);
        AreaListInfo areaListInfo = new AreaListInfo();
        areaListInfo.setAreaList(data);
        return AppResponse.success("查询成功",areaListInfo);
    }
}
