package myong.mall.manage.upload.api;

import com.alibaba.dubbo.config.annotation.Service;
import myong.mall.manage.upload.service.IApiUploadService;
import myong.mall.manage.upload.service.IUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * @ClassName UploadService
 * @Description TODO
 * @Author
 * @CreateDate
 * @UpdateUser
 * @UpdateDate: 2019/9/21 17:26
 * @UpdateRemark: 修改内容
 * @Version 1.0
 **/
@Service(version = "${dubbo.service.version}")
public class UploadService implements IApiUploadService {

    @Autowired
    private IUploadService uploadService;

    @Override
    public String uploadImage(CommonsMultipartFile file) {
        return uploadService.uploadImage(file);
    }

    @Override
    public String test(){
        return  "success";
    }

}
