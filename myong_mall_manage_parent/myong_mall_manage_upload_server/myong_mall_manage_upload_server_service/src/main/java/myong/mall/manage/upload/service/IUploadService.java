package myong.mall.manage.upload.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * 文件上传业务接口
 */
public interface IUploadService {

    /**
     * 上传图片
     * @param file
     * @return
     */
    public String uploadImage(CommonsMultipartFile file);
}
