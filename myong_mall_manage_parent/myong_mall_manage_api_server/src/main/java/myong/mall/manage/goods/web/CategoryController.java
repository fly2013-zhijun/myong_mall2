package myong.mall.manage.goods.web;

import myong.mall.manage.enums.ResponseStatusEnum;
import myong.mall.manage.exception.YongException;
import myong.mall.manage.goods.entity.GoodsCategory;
import myong.mall.manage.goods.service.CategoryService;
import myong.mall.manage.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName CategoryController        web交互控制层
 * @Description TODO
 * @Author          flyong
 * @CreateDate
 * @UpdateUser
 * @UpdateDate: 2019/9/23 12:37
 * @UpdateRemark: 修改内容
 * @Version 1.0
 **/
@CrossOrigin
@RestController
@RequestMapping("/goods/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 查询需要显示的分类列表
     * @param parentId          父类id
     * @return
     */
    @GetMapping("/list/{id}")
    public ResponseEntity<ResponseResult> findCategoriesByParentId(@PathVariable("id") Long parentId) {
        List<GoodsCategory> categories = categoryService.findCategoryByParentId(parentId);

        if (!CollectionUtils.isEmpty(categories)) {
            return ResponseEntity.ok(new ResponseResult(true, ResponseStatusEnum.OK,
                    categories));

        }
        throw new YongException(ResponseStatusEnum.IS_NULL);
    }
//        @GetMapping("/list/{id}")
//        public ResponseEntity<List<GoodsCategory>> findCategoriesByParentId(@PathVariable("id") Long parentId) {
//            List<GoodsCategory> categories = categoryService.findCategoryByParentId(parentId);
//
//            if (!CollectionUtils.isEmpty(categories)) {
//                return ResponseEntity.ok(categories);
//            }
//            throw new YongException(ResponseStatusEnum.IS_NULL);
//        }

    /**
     * 新增分类
     * @param category      新增的分类对象
     * @param parentId      分类对象的父级id
     * @return
     */
    @PostMapping("/children/{parentId}")
    public ResponseEntity<ResponseResult> add(@RequestBody GoodsCategory category,
                                                        @PathVariable(name="parentId",required = true) Long parentId) {
        Boolean flag = categoryService.addCategory(category, parentId);

        if (flag) {
            return ResponseEntity.ok(new ResponseResult(true, ResponseStatusEnum.OK));
        }

        throw new YongException(ResponseStatusEnum.UPDATE_FAILED);
    }

    /**
     * 更新分类
     * @param category      分类对象
     * @param id            id
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<ResponseResult> update(@RequestBody GoodsCategory category,@PathVariable("id") Long id){
        Boolean flag = categoryService.updateCategory(category,id);
        if (flag) {
            return ResponseEntity.ok(new ResponseResult(true, ResponseStatusEnum.OK));
        }

        throw new YongException(ResponseStatusEnum.UPDATE_FAILED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseResult> del(@PathVariable(name = "id",required = true) Long id){

        Boolean flag = categoryService.delCategory(id);

        if (flag) {
            return ResponseEntity.ok(new ResponseResult(true, ResponseStatusEnum.OK));
        }

        throw new YongException(ResponseStatusEnum.DELETE_FAILED);

    }


    //http://127.0.0.1:8081/api/goods/category/1177515287549964300

    @GetMapping("/{bid}")
    public ResponseEntity<ResponseResult> findCategoriesByBrandId(@PathVariable(value = "bid",required = true)Long bid){
        List<GoodsCategory> categories = categoryService.findCategoriesByBrandId(bid);
        if(!CollectionUtils.isEmpty(categories)){
            return  ResponseEntity.ok( new ResponseResult(true,ResponseStatusEnum.OK,categories));
        }
        throw new YongException(ResponseStatusEnum.IS_NULL);
    }

}
