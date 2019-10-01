package myong.mall.manage.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName PageResult        页面封装类
 * @Description TODO
 * @Author          flyong
 * @CreateDate
 * @UpdateUser
 * @UpdateDate: 2019/9/21 16:18
 * @UpdateRemark: 修改内容
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = -9143507773409463624L;
    private Integer currentPage;
    private Integer size;
    private Long    total;
    private List<T> items = Collections.emptyList();
}
