package myong.mall.manage.goods.service;

import com.alibaba.dubbo.config.annotation.Reference;
import myong.mall.manage.goods.entity.GoodsCategory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CategoryService           api 业务处理类
 * @Description TODO
 * @Author      flyong
 * @CreateDate
 * @UpdateUser
 * @UpdateDate: 2019/9/23 11:54
 * @UpdateRemark: 修改内容
 * @Version 1.0
 **/
@Service
public class CategoryService {

    @Reference(version = "${dubbo.service.version}")
    private IApiCategoryService categoryService;



    /**
     * 根据父类id查询所有的分类列表
     * @param parentId
     * @return
     */
    public List<GoodsCategory> findCategoryByParentId(Long parentId) {
        return categoryService.findCategoryByParentId(parentId);
    }

    /**
     * 根据父类id查询需要显示的分类列表
     * @param parentId
     * @return
     */
    public List<GoodsCategory> findShowCategoriesByParentId(Long parentId) {
        return categoryService.findShowCategoriesByParentId(parentId);
    }

    /**
     * 新增分类对象
     * @param category      分类对象
     * @param parentId      父级id
     * @return
     */
    public Boolean addCategory(GoodsCategory category, Long parentId) {
        return categoryService.addCategory(category,parentId);
    }

    /**
     * 更新分类对象
     * @param category
     * @param id
     * @return
     */
    public Boolean updateCategory(GoodsCategory category, Long id) {
        return categoryService.updateCategory(category,id);
    }

    /**
     * 删除id
     * @param id
     * @return
     */
    public Boolean delCategory(Long id) {
       return   categoryService.delCategory(id);
    }

    /**
     * 根据品牌id查询对应的分类列表
     * @param bid
     * @return
     */
    public List<GoodsCategory> findCategoriesByBrandId(Long bid) {
        return categoryService.findCategoriesByBrandId(bid);
    }
}
