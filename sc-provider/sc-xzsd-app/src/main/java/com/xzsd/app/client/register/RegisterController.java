package com.xzsd.app.client.register;

import com.neusoft.core.restful.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/register")
public class RegisterController {
    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
    @Resource RegisterService registerService;

    @PostMapping("/clientRegister")
    public AppResponse clientRegister(RegisterInfo registerInfo){
        try{
            return registerService.clientRegister(registerInfo);
        }catch (Exception e){
            logger.error("注册失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
