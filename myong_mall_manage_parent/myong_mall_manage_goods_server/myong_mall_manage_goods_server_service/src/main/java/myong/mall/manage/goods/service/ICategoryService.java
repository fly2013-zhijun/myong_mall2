package myong.mall.manage.goods.service;

import myong.mall.manage.goods.entity.GoodsCategory;

import java.util.List;

/**
 * 商品分类业务接口
 */
public interface ICategoryService {

    /**
     * 根据父节点查询分类集合
     * @param parentId          父级id
     * @return
     */
    public List<GoodsCategory> findCategoryByParentId(Long parentId);

    /**
     * 根据父节点查询用于显示的分类列表
     * @param parentId
     * @return
     */
    public List<GoodsCategory> findShowCategoriesByParentId(Long parentId);

    /**
     * 新增分类
     * @param category      新增的分类对象
     * @param parentId      父级id
     * @return
     */
    public Boolean addCategory(GoodsCategory category, Long parentId);

    /**
     * 更新分类
     * @param category
     * @param id
     * @return
     */
    public Boolean updateCategory(GoodsCategory category, Long id);

    /**
     * 删除分类
     * @param id
     * @return
     */
    public Boolean delCategory(Long id);

    /**
     * 根据品牌id查询所属的分类列表
     * @param bid
     * @return
     */
    public List<GoodsCategory> findCategoriesByBrandId(Long bid);
}
