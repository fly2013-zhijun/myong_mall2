package myong.mall.manage.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @ClassName UploadProperties  上传文件的一些参数封装类
 * @Description TODO
 * @Author      flyong
 * @CreateDate
 * @UpdateUser
 * @UpdateDate: 2019/9/22 5:31
 * @UpdateRemark: 修改内容
 * @Version 1.0
 **/
@Data
@ConfigurationProperties(prefix = "upload.file")
public class UploadProperties {
    private String          baseUrl;            //文件访问的基本路径(文件的访问路径=baseurl+文件在fastDFS的存储路径)
    private List<String>    allowTypes;         //文件格式集合
}
