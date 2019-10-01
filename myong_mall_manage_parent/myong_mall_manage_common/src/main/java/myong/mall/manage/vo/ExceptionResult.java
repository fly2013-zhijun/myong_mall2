package myong.mall.manage.vo;

import lombok.Data;
import myong.mall.manage.enums.ResponseStatusEnum;

/**
 * @ClassName ExceptionResult       异常响应结果类
 * @Description TODO
 * @Author          flyong
 * @CreateDate
 * @UpdateUser
 * @UpdateDate: 2019/9/17 18:21
 * @UpdateRemark: 修改内容
 * @Version 1.0
 **/
@Data
public class ExceptionResult {
    private Boolean flag = false;
    private Integer code;               //异常码
    private String  message;            //异常信息
    private Long    timeStamp;          //时间戳

    public ExceptionResult(ResponseStatusEnum exceptionEnum){

        this.code = exceptionEnum.getCode();
        this.message = exceptionEnum.getMessage();
        this.timeStamp = System.currentTimeMillis();
    }

    public ExceptionResult(Integer code,String message){
        this.timeStamp = System.currentTimeMillis();
        this.message = message;
        this.code = code;
        this.flag = false;
    }

}
