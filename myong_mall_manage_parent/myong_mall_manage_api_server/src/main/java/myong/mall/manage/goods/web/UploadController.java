package myong.mall.manage.goods.web;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import myong.mall.manage.enums.ResponseStatusEnum;
import myong.mall.manage.exception.YongException;
import myong.mall.manage.goods.config.UploadProperties;
import myong.mall.manage.vo.ResponseResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * @ClassName UploadController
 * @Description TODO
 * @Author          flyong
 * @CreateDate
 * @UpdateUser
 * @UpdateDate: 2019/9/21 20:57
 * @UpdateRemark: 修改内容
 * @Version 1.0
 **/
@CrossOrigin
//@Configuration
@RestController
@RequestMapping("/upload")
@EnableConfigurationProperties(UploadProperties.class)
public class UploadController {

    @Autowired
    private UploadProperties uploadProperties;

    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    @PostMapping("/image")
    public ResponseEntity<ResponseResult> uploadImage(MultipartFile file){
        //获取文件类型
        String contentType = file.getContentType();

        if(uploadProperties.getAllowTypes().contains(contentType)){ //判断文件类型
            try {
                if(ImageIO.read(file.getInputStream()) != null){//判断文件类型
                    String extension = StringUtils.substringAfterLast(file.getOriginalFilename(),".");
                    StorePath storePath = fastFileStorageClient.uploadFile(file.getInputStream(), file.getSize(), extension, null);
                    return ResponseEntity.ok(new ResponseResult(true, ResponseStatusEnum.OK,
                                                    StringUtils.join(uploadProperties.getBaseUrl(),storePath.getFullPath())));
                }
            } catch (IOException e) {
                throw new YongException(ResponseStatusEnum.UPLOAD_FILE_FAILED);
            }
        }

        throw new YongException(ResponseStatusEnum.INVILID_FILE_TYPE);
    }

}
