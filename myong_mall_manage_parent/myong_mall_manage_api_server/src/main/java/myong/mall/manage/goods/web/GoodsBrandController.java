package myong.mall.manage.goods.web;

import myong.mall.manage.enums.ResponseStatusEnum;
import myong.mall.manage.exception.YongException;
import myong.mall.manage.goods.entity.GoodsBrand;
import myong.mall.manage.goods.service.GoodsBrandService;
import myong.mall.manage.vo.PageResult;
import myong.mall.manage.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName GoodsBrandController
 * @Description TODO
 * @Author          flyong
 * @CreateDate
 * @UpdateUser
 * @UpdateDate: 2019/9/17 20:06
 * @UpdateRemark: 修改内容
 *
 * @Version 1.0
 **/
@CrossOrigin(methods = {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.HEAD,
                                RequestMethod.PUT,RequestMethod.POST,RequestMethod.OPTIONS}
                                )
@RestController
@RequestMapping("/goods/brand")
public class GoodsBrandController {

    @Autowired
    private GoodsBrandService goodsBrandService;

    /**
     * 查询所有
     * @return
     */
    @GetMapping
    public ResponseEntity<ResponseResult> getAll(){

        List<GoodsBrand> brands = goodsBrandService.queryAll();

        if(!CollectionUtils.isEmpty(brands)){
            return ResponseEntity.ok(new ResponseResult(true,ResponseStatusEnum.OK,brands));
        }

        throw new YongException(ResponseStatusEnum.IS_NULL);
    }

    /**
     * 分页条件查询 并按排序字段升序排序
     * @param brand     查询对象封装条件
     * @param page      当前页
     * @param size      页面容量
     * @return
     */
    @PostMapping("/{page}/{size}")
    public ResponseEntity<ResponseResult> findOfByPage(@RequestBody GoodsBrand brand,
                                                               @PathVariable(name="page",required = true) Integer page,
                                                               @PathVariable(name = "size",required = true) Integer size){
        PageResult<GoodsBrand> pageResult = goodsBrandService.queryByPage(brand, page, size);
        if(!CollectionUtils.isEmpty(pageResult.getItems())){
            return ResponseEntity.ok(new ResponseResult(true,ResponseStatusEnum.OK,pageResult));
        }

        throw new YongException(ResponseStatusEnum.IS_NULL);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ResponseResult> findById(@PathVariable(name = "id",required = true) Long id){
        GoodsBrand goodsBrand = goodsBrandService.findById(id);
        if(goodsBrand != null){
            return ResponseEntity.ok(new ResponseResult(true,ResponseStatusEnum.OK,goodsBrand));
        }
        throw new YongException(ResponseStatusEnum.IS_NULL);
    }

    @PostMapping
    /**
     * json格式的数据才需要在对象前加@ReqeustBody
     * 普通的@RequestParam 这样的数据映射到对象上只需对象中的属性名称一致即可
     * from表单提交的数据是json格式的,而且只能用一个对象来接受.
     * 这里拆分成了两个是在前端通过插件将整个表单的输出转换为了普通的请求数据.
     */
    public ResponseEntity<ResponseResult> add(GoodsBrand brand,
                                                @RequestParam(value = "cids") List<Long>cids){
        System.out.println(brand);
        System.out.println(cids);
        Boolean flag = goodsBrandService.add(brand,cids);
        if(flag){
            return ResponseEntity.ok(new ResponseResult(true,ResponseStatusEnum.OK));
        }
        throw new YongException(ResponseStatusEnum.ADD_FAILED);
    }

    //http://api.myong.com/api/goods/brand/58
    @PutMapping("/{id}")
    public ResponseEntity<ResponseResult> update(GoodsBrand brand,
                                                                @PathVariable(value = "id",required = true) Long id,
                                                                @RequestParam("cids") List<Long> cids){
        Boolean flag = goodsBrandService.update(brand,id,cids);
        if(flag){
            return ResponseEntity.ok(new ResponseResult(true,ResponseStatusEnum.OK));
        }
        throw new YongException(ResponseStatusEnum.UPDATE_FAILED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseResult> del(@PathVariable(name = "id",required = true) Long id){
        Boolean flag = goodsBrandService.delById(id);
        if(flag){
            return ResponseEntity.ok(new ResponseResult(true,ResponseStatusEnum.OK));
        }
        throw new YongException(ResponseStatusEnum.DELETE_FAILED);
    }

    //http://127.0.0.1:8081/api/goods/brand/page?key=H&page=1&rows=5&sortBy=id&desc=false
    @GetMapping("page")
    public ResponseEntity<ResponseResult> findOfByPage(@RequestParam(name="key",required = false) String key,
                                                        @RequestParam(name="page",defaultValue = "1") int page,
                                                        @RequestParam(name="rows",defaultValue = "5") int rows,
                                                        @RequestParam(name="sortBy",defaultValue = "id") String sortBy, @RequestParam(name="desc",defaultValue = "false") Boolean desc){

        PageResult<GoodsBrand> pageResult  = goodsBrandService.findOfByPage(key, page, rows, sortBy, desc);

        if(!CollectionUtils.isEmpty(pageResult.getItems())){
            return  ResponseEntity.ok(new ResponseResult(true,ResponseStatusEnum.OK,pageResult));
        }

        throw new YongException(ResponseStatusEnum.IS_NULL);
    }


}
