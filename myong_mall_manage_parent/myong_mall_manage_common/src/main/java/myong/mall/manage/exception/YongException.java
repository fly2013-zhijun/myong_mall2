package myong.mall.manage.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import myong.mall.manage.enums.ResponseStatusEnum;

/**
 * @ClassName YongException         项目异常处理
 * @Description TODO
 * @Author      flyong
 * @CreateDate
 * @UpdateUser
 * @UpdateDate: 2019/9/17 18:01
 * @UpdateRemark: 修改内容
 * @Version 1.0
 **/
@AllArgsConstructor
@Getter
public class YongException extends RuntimeException {

    private ResponseStatusEnum exceptionEnum;

}
