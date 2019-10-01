package myong.mall.manage.goods.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @ClassName GoodsCategory         商品分类实体类
 * @Description TODO
 * @Author      flyong
 * @CreateDate
 * @UpdateUser
 * @UpdateDate: 2019/9/22 22:10
 * @UpdateRemark: 修改内容
 * @Version 1.0
 **/
@Table(name = "goods_category")
@Data
public class GoodsCategory implements Serializable {
    private static final long serialVersionUID = -5873250040991096509L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id;            //id
    private String  name;          //分类名称
    private Long    parentId;      //父级id
    private Integer isParent;      //是否是父级类目  1:是 0:不是
    private Integer seq;           //排序,值越小排序越靠前
    private Integer isShow;        //是否显示 1:显示，0:不显示
}
