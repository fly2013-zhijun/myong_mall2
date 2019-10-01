package myong.mall.manage;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ClassName GoodsServerProviderApp        商品服务提供者启动类
 * @Description TODO
 * @Author
 * @CreateDate
 * @UpdateUser
 * @UpdateDate: 2019/9/17 19:49
 * @UpdateRemark: 修改内容
 * @Version 1.0
 **/
@SpringBootApplication
@MapperScan(basePackages = "myong.mall.manage.goods.mapper")
public class GoodsServerProviderApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(GoodsServerProviderApp.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }
}
