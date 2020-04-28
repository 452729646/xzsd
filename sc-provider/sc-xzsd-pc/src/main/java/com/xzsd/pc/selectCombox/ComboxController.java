package com.xzsd.pc.selectCombox;

import com.neusoft.core.restful.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 地区下拉框
 * @author housum
 * @date 2020-4-25
 */
@RestController
@RequestMapping("/selectCombox")
public class ComboxController {
    private static final Logger logger = LoggerFactory.getLogger(ComboxController.class);

    @Resource ComboxService comboxService;

    @PostMapping("listArea")
    public AppResponse listArea(RegionInfo regionInfo){
        try {
            return comboxService.listArea(regionInfo);
        }catch (Exception e){
            logger.error("查询地区下拉框失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
