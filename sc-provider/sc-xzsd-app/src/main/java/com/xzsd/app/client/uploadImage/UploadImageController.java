package com.xzsd.app.client.uploadImage;

import com.neusoft.core.restful.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;


@RestController
@RequestMapping("/image")
public class UploadImageController {
    private static final Logger logger = LoggerFactory.getLogger(UploadImageController.class);
    @Resource UploadImageService uploadImageService;

    @PostMapping("uploadImage")
    public AppResponse uploadImage( MultipartFile imageFile) throws IOException {
        try{

            AppResponse appResponse = uploadImageService.uploadImage(imageFile);
            return appResponse;
        }catch (Exception e){
            logger.error("上传图片失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

}