package com.xzsd.pc.uploadImage;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.utils.TencentCOS;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @DescriptionDemo 实现类
 * @Author housum
 * @Date 2020-04-16
 */
@Service
public class UploadImageService {

    public AppResponse uploadImage (MultipartFile imageFile) throws IOException {
        //获取文件的名称
        String fileName = imageFile.getOriginalFilename();

        //判断有无后缀
        if (fileName.lastIndexOf(".") < 0){
            return AppResponse.bizError("上传图片格式不正确,无后缀");
        }

        //获取文件后缀
        String prefix = fileName.substring(fileName.lastIndexOf("."));

        //如果不是图片
        if (!prefix.equalsIgnoreCase(".jpg") && !prefix.equalsIgnoreCase(".jpeg") && !prefix.equalsIgnoreCase(".svg") && !prefix.equalsIgnoreCase(".gif") && !prefix.equalsIgnoreCase(".png")) {
            return AppResponse.bizError("上传图片格式不正确");
        }
        //使用uuid作为文件名，防止生成的临时文件重复
        final File excelFile = File.createTempFile("imagesFile-" + System.currentTimeMillis(), prefix);
        //将Multifile转换成File
        imageFile.transferTo(excelFile);

        String imageName = TencentCOS.uploadfile(excelFile, "avatar");

        //程序结束时，删除临时文件
        deleteFile(excelFile);
        ImageInfo imageInfo = new ImageInfo();
        imageInfo.setImagePath("https://xzsd-1300629556.cos.ap-guangzhou.myqcloud.com/"+imageName);

        return AppResponse.success("上传成功",imageInfo);



    }
    /**
     * 删除临时文件
     *
     * @param files 临时文件，可变参数
     */
    private void deleteFile(File... files) {
        for (File file : files) {
            if (file.exists()) {
                file.delete();
            }
        }
    }
}
