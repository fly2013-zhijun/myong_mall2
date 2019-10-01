package myong.mall.manage.upload.service.impl;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import lombok.extern.slf4j.Slf4j;
import myong.mall.manage.config.UploadProperties;
import myong.mall.manage.enums.ResponseStatusEnum;
import myong.mall.manage.exception.YongException;
import myong.mall.manage.upload.service.IUploadService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * @ClassName UploadServiceImpl  文件上传业务实现类
 * @Description TODO
 * @Author
 * @CreateDate
 * @UpdateUser
 * @UpdateDate: 2019/9/29 15:17
 * @UpdateRemark: 修改内容
 * @Version 1.0
 **/
@Slf4j
@EnableConfigurationProperties(UploadProperties.class)
@Service
public class UploadServiceImpl implements IUploadService {

    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    @Autowired
    private UploadProperties uploadProperties;

    @Override
    public String uploadImage(CommonsMultipartFile file) {

        String contentType = file.getContentType();  //获取文件类型

        //判断图片是否是指定的类型
        if(uploadProperties.getAllowTypes().contains(contentType)){
            try {
                if(ImageIO.read(file.getInputStream()) != null){    //判断是否图片
                    String originalFilename = file.getOriginalFilename(); //获取文件上传名
                    String extension = StringUtils.substringAfterLast(originalFilename,".");  //截取扩展名
                    //将文件上传至fastDfs 并获取 存储路径对象
                    StorePath storePath = fastFileStorageClient.uploadFile(file.getInputStream(),
                                                                            file.getSize(), extension, null);
                    //返回访问该图片的路径
                    return StringUtils.join(uploadProperties.getBaseUrl(),storePath.getFullPath());
                }
            } catch (IOException e) {
                e.printStackTrace();
                log.error("文件上传失败");
                throw new YongException(ResponseStatusEnum.UPLOAD_FILE_FAILED);
            }
        }
        log.error("文件类型不匹配");
        throw new YongException(ResponseStatusEnum.IS_NULL);
    }

}
