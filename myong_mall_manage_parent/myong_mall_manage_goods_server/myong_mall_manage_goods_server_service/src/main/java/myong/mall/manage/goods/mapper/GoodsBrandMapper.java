package myong.mall.manage.goods.mapper;

import myong.mall.manage.goods.entity.GoodsBrand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 商品品牌数据接口
 */
public interface GoodsBrandMapper extends Mapper<GoodsBrand> {

    /**
     * 品牌和商品分类的中间表
     * @param bid
     * @param cids
     * @return
     */
    @Insert("<script>insert into goods_category_brand (category_id,brand_id) values " +
            "<foreach collection='cids' item='cid' separator=','>(#{cid},#{bid})</foreach></script>")
    public int insertCategoryAndBrand(@Param("bid") Long bid, @Param("cids") List<Long> cids);

    /**
     * 根据品牌id查询关联的三级分类id集合
     * @param bid
     * @return
     */
    @Select("select category_id from goods_category_brand where brand_id = #{bid}")
    public List<Long> findBrandAssociationCategoryIds(Long bid);

    @Delete("delete from goods_category_brand where brand_id = #{id}")
    public int delCategoryAssociationBrandByBrandId(Long bid);
}
