//package myong.mall.manage.goods.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.multipart.MultipartResolver;
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;
//
///**
// * @ClassName UploadConfig
// * @Description TODO
// * @Author myong
// * @CreateDate
// * @UpdateUser myong
// * @UpdateDate: 2019/9/29 16:53
// * @UpdateRemark: 修改内容
// * @Version 1.0
// **/
//@Configuration
//public class UploadConfig {
//
//    @Bean(name = "multipartResolver")
//    public MultipartResolver multipartResolver(){
//        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//        resolver.setDefaultEncoding("UTF-8");
//        resolver.setResolveLazily(true);//resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常
//        resolver.setMaxInMemorySize(40960);
//        resolver.setMaxUploadSize(50*1024*1024);//上传文件大小 50M 50*1024*1024
//        return resolver;
//    }
//
//}
