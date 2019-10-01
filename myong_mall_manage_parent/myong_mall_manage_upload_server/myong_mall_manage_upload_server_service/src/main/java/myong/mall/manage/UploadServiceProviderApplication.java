package myong.mall.manage;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @ClassName UploadServiceApplication
 * @Description TODO
 * @Author
 * @CreateDate
 * @UpdateUser
 * @UpdateDate: 2019/9/21 13:56
 * @UpdateRemark: 修改内容
 * @Version 1.0
 **/
@SpringBootApplication
public class UploadServiceProviderApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(UploadServiceProviderApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }
}
