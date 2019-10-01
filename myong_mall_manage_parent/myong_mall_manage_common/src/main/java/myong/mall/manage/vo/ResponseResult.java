package myong.mall.manage.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import myong.mall.manage.enums.ResponseStatusEnum;

/**
 * @ClassName ResponseResult  响应结果
 * @Description TODO
 * @Author flyong
 * @CreateDate
 * @UpdateUser flyong
 * @UpdateDate: 2019/9/23 13:10
 * @UpdateRemark: 修改内容
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
public class ResponseResult {
    private Boolean flag;       //响应状态 true:请求成功,false:请求失败
    private Integer code;       //状态码
    private String  message;    //响应信息
    private Object  data;       //响应数据

    public ResponseResult(Boolean flag, ResponseStatusEnum statusEnum){
        this.flag = flag;
        this.code = statusEnum.getCode();
        this.message = statusEnum.getMessage();
    }

    public ResponseResult(Boolean flag,ResponseStatusEnum statusEnum,Object data){
        this.flag = flag;
        this.code = statusEnum.getCode();
        this.message = statusEnum.getMessage();
        this.data = data;
    }
}
