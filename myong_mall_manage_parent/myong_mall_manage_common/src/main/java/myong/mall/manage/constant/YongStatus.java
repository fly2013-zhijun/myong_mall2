package myong.mall.manage.constant;

/**
 * @ClassName YongStatus    状态码
 * @Description TODO
 * @Author      flyong
 * @CreateDate
 * @UpdateUser
 * @UpdateDate: 2019/9/23 12:56
 * @UpdateRemark: 修改内容
 * @Version 1.0
 **/
public class YongStatus {

    public final static int OK = 20000;                     //操作成功

    public final static int IS_NULL = 20001;                //查询对象为空

    public final static int ADD_FAILED = 20002;             //新增失败

    public final static int DELETE_FAILED = 20003;          //删除失败

    public final static int UPDATE_FAILED = 20004;          //更新失败

    public final static int UPLOAD_FILE_FAILED = 30000;     //文件上传失败

    public final static int INVALID_FILE_TYPE = 30001;      //文件类型错误

    public final static int NULL_POINTER = 10000;           //空指针异常

    public final static int SYSTEM_EXCEPTION = 10001;       //系统异常
    public static final int  RUNTIME_EXCEPTION = 1002;
}
