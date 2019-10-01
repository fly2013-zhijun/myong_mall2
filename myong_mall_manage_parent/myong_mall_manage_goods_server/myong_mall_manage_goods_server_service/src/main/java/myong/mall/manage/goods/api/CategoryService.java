package myong.mall.manage.goods.api;

import com.alibaba.dubbo.config.annotation.Service;
import myong.mall.manage.goods.entity.GoodsCategory;
import myong.mall.manage.goods.service.IApiCategoryService;
import myong.mall.manage.goods.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName CategoryService       分类web接口业务实现层
 * @Description TODO
 * @Author          flyong
 * @CreateDate
 * @UpdateUser
 * @UpdateDate: 2019/9/23 11:49
 * @UpdateRemark: 修改内容
 * @Version 1.0
 **/
@Service(version = "${dubbo.service.version}")
public class CategoryService implements IApiCategoryService {

    @Autowired
    private ICategoryService categoryService;

    @Override
    public List<GoodsCategory> findCategoryByParentId(Long parentId) {
        return categoryService.findCategoryByParentId(parentId);
    }

    @Override
    public List<GoodsCategory> findShowCategoriesByParentId(Long parentId) {
        return categoryService.findShowCategoriesByParentId(parentId);
    }

    @Override
    public Boolean addCategory(GoodsCategory category, Long parentId) {
        return categoryService.addCategory(category,parentId);
    }

    @Override
    public Boolean updateCategory(GoodsCategory category, Long id) {
        return categoryService.updateCategory(category,id);
    }

    @Override
    public Boolean delCategory(Long id) {
         return categoryService.delCategory(id);
    }

    @Override
    public List<GoodsCategory> findCategoriesByBrandId(Long bid) {
        return categoryService.findCategoriesByBrandId(bid);
    }
}
