package myong.mall.manage.upload.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * 文件上传web api接口
 */
public interface IApiUploadService {

    /**
     * 上传图片
     * @param file
     * @return
     */
    public String uploadImage(CommonsMultipartFile file);


    public String test();
}
