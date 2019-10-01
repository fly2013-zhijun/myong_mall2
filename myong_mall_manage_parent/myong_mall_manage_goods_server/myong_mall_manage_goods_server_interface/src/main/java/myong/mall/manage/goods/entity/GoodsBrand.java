package myong.mall.manage.goods.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @ClassName GoodBrand  商品品牌
 * @Description TODO
 * @Author      flyong
 * @CreateDate
 * @UpdateUser
 * @UpdateDate: 2019/9/17 12:05
 * @UpdateRemark: 修改内容
 * @Version 1.0
 **/
@Accessors(chain = true)
@Table(name="goods_brand")
@Data
public class GoodsBrand implements Serializable {
    private static final long serialVersionUID = 3792774338744077976L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //主键自动增长
    private Long id;
    private String name;                    //品牌名称
    private String firstLetter;             //品牌首字母
    private Integer sort;                   //排序
    private Integer factoryStatus;          //是否是品牌制造商  1:是 0:不是
    private Integer showStatus;             //是否显示 1:显示 0:不显示
    private Integer productCount;           //产品数量
    private Integer productCommentCount;    //产品评论数
    private String logo;                    //品牌logo
    private String bigPic;                  //专区大图
    private String brandStory;              //品牌故事

}
