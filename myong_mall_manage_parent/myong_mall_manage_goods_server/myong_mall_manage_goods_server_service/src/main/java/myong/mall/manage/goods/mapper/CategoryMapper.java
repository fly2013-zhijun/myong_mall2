package myong.mall.manage.goods.mapper;

import myong.mall.manage.goods.entity.GoodsCategory;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @ClassName   CategoryMapper        分类数据层接口
 * @Description 继承至通用mapper
 * @Author      flyong
 * @CreateDate
 * @UpdateUser
 * @UpdateDate: 2019/9/23 6:51
 * @UpdateRemark: 修改内容
 * @Version 1.0
 **/
public interface CategoryMapper extends Mapper<GoodsCategory> {

    /**
     * 根据父级id设置是否显示分类
     * @param isShow
     * @param parentId
     * @return
     */
    @Update("update goods_category set is_show = #{isShow} where parent_id = #{parentId}")
    public int setCategoryIsShowByParentId(@Param("isShow")Integer isShow,@Param("parentId") Long parentId);

    @Select("select c.id id,c.name name,c.parent_id parent_id,c.is_parent is_parent,c.seq seq,c.is_show is_show " +
                "from goods_category c inner join goods_category_brand cb " +
                "on c.id = cb.category_id where cb.brand_id = #{bid}")
    public List<GoodsCategory> findCategoriesByBrandId(Long bid);


}
