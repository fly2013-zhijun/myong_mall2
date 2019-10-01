package myong.mall.manage.advice;

import lombok.extern.slf4j.Slf4j;
import myong.mall.manage.constant.YongStatus;
import myong.mall.manage.enums.ResponseStatusEnum;
import myong.mall.manage.exception.YongException;
import myong.mall.manage.vo.ExceptionResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName YongExceptionHandler      //通用异常处理
 * @Description TODO
 * @Author      flyong
 * @CreateDate
 * @UpdateUser
 * @UpdateDate: 2019/9/17 18:19
 * @UpdateRemark: 修改内容
 * @Version 1.0
 **/
@Slf4j
@RestControllerAdvice
public class YongExceptionHandler {

    /**
     * 自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(YongException.class)
    public ResponseEntity<ExceptionResult> webExceptionHandle(YongException e){


            ResponseStatusEnum exceptionEnum = e.getExceptionEnum();
            log.error(exceptionEnum.getMessage());
            return ResponseEntity.status(exceptionEnum.getCode())
                                    .body(new ExceptionResult(exceptionEnum));

    }

    /**
     * 空指针异常
     * @param e
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ExceptionResult> nullPointerExceptionHandle(NullPointerException e){

        log.error("空指针异常");
        return ResponseEntity.badRequest().body(new ExceptionResult(ResponseStatusEnum.NULL_POINTER));

    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResult> runtimeExceptionHandle(RuntimeException e){
        log.error(e.getMessage());
        return ResponseEntity.badRequest().
                                body(new ExceptionResult(YongStatus.RUNTIME_EXCEPTION,e.getMessage()));

    }

    /**
     * 系统异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResult> sysExceptionHandle(Exception e){
        log.error(e.getMessage());
        return ResponseEntity.badRequest().body(new ExceptionResult(YongStatus.SYSTEM_EXCEPTION,e.getMessage()));

    }


}
