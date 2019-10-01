//package myong.mall.manage.goods.service;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import myong.mall.manage.upload.service.IApiUploadService;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.commons.CommonsMultipartFile;
//
///**
// * @ClassName UploadService     文件上传
// * @Description TODO
// * @Author myong
// * @CreateDate
// * @UpdateUser myong
// * @UpdateDate: 2019/9/29 15:39
// * @UpdateRemark: 修改内容
// * @Version 1.0
// **/
//@Service
//public class UploadService {
//    @Reference(version = "${dubbo.service.version}")
//    private IApiUploadService apiUploadService;
//
//    public String uploadImage(CommonsMultipartFile file) {
//        System.out.println(apiUploadService == null);
//        return apiUploadService.uploadImage(file);
//    }
//
//    public String test(){
//        return  apiUploadService.test();
//    }
//}
