package myong.mall.manage.goods.service.impl;

import lombok.extern.slf4j.Slf4j;
import myong.mall.manage.goods.entity.GoodsCategory;
import myong.mall.manage.goods.mapper.CategoryMapper;
import myong.mall.manage.goods.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName CategoryServiceImpl     商品业务接口实现类
 * @Description TODO
 * @Author          flyong
 * @CreateDate
 * @UpdateUser
 * @UpdateDate: 2019/9/23 6:47
 * @UpdateRemark: 修改内容
 * @Version 1.0
 **/
@Slf4j
@Service                                //注意这里使用的@service是Spring的
@Transactional
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<GoodsCategory> findCategoryByParentId(Long parentId) {

        GoodsCategory goodsCategory = new GoodsCategory();

        goodsCategory.setParentId(parentId);

        return  categoryMapper.select(goodsCategory);

    }

    @Override
    public List<GoodsCategory> findShowCategoriesByParentId(Long parentId) {
        GoodsCategory goodsCategory = new GoodsCategory();

        goodsCategory.setParentId(parentId);

        goodsCategory.setIsShow(1);

        return  categoryMapper.select(goodsCategory);
    }

    @Override
    public Boolean addCategory(GoodsCategory category, Long parentId) {

        category.setParentId(parentId);
        //用户没有设置当前排序字段的情况下该字段默认自动增长
        if(null == category.getSeq()){
            GoodsCategory goodsCategory = new GoodsCategory();
            goodsCategory.setParentId(parentId);
            Integer count = categoryMapper.selectCount(goodsCategory);
            category.setSeq(count+1);
        }
        int insert = 0;
        try {
            insert = categoryMapper.insert(category);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("新增失败");
        }
        return 1 ==  insert;
    }

    @Override
    public Boolean updateCategory(GoodsCategory category, Long id) {
         category.setId(id);
        int update = 0;
        try {
            //这里异常需要手动捕获一下
            update = categoryMapper.updateByPrimaryKey(category);
        } catch (Exception e) {
            e.printStackTrace();
           log.error("更新失败");
        }
        return  1 == update;
    }

    @Override
    public Boolean delCategory(Long id) {

        try {
            GoodsCategory category = categoryMapper.selectByPrimaryKey(id); //根据主键获取对象
            category.setIsShow(0);  //将isshow字段设置为0,隐藏
            updateCategory(category, id);
            if (1 == category.getIsParent()) {
                setIsShowChildren(category);
            }
            return true;
        } catch (Exception e) {
            log.error("删除失败");
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 删除(隐藏)子集分类
     * @param category
     */
    private void setIsShowChildren(GoodsCategory category){
        if(1 == category.getIsParent()){
            categoryMapper.setCategoryIsShowByParentId(0,category.getId());
            for (GoodsCategory category1:findCategoryByParentId(category.getId())){
                setIsShowChildren(category1);
            }
        }else {
            return;
        }
    }

    @Override
    public List<GoodsCategory> findCategoriesByBrandId(Long bid) {
        return categoryMapper.findCategoriesByBrandId(bid);
    }
}
