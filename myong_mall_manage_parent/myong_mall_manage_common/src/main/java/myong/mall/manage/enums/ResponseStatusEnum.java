package myong.mall.manage.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import myong.mall.manage.constant.YongStatus;

/**
 * @ClassName ExceptionEnum             异常枚举
 * @Description TODO
 * @Author      flyong
 * @CreateDate
 * @UpdateUser
 * @UpdateDate: 2019/9/17 18:13
 * @UpdateRemark: 修改内容
 * @Version 1.0
 **/
@AllArgsConstructor
@Getter
public enum  ResponseStatusEnum{
    OK(YongStatus.OK,"ok"),
    IS_NULL(YongStatus.IS_NULL,"查询对象为空"),
    ADD_FAILED(YongStatus.ADD_FAILED,"新增失败"),
    DELETE_FAILED(YongStatus.DELETE_FAILED,"删除失败"),
    UPDATE_FAILED(YongStatus.UPDATE_FAILED,"更新失败"),
    UPLOAD_FILE_FAILED(YongStatus.UPLOAD_FILE_FAILED,"上传文件失败"),
    INVILID_FILE_TYPE(YongStatus.INVALID_FILE_TYPE,"文件类型错误"),
    NULL_POINTER(YongStatus.NULL_POINTER,"空指针异常"),
    SYSTEM_EXCEPTION(YongStatus.SYSTEM_EXCEPTION,"系统异常");

    private Integer code;
    private String message;
}
