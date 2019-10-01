package myong.mall.manage.goods.service;

import com.alibaba.dubbo.config.annotation.Reference;
import myong.mall.manage.goods.entity.GoodsBrand;
import myong.mall.manage.vo.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName GoodsBrandService
 * @Description TODO
 * @Author      flyong
 * @CreateDate
 * @UpdateUser
 * @UpdateDate: 2019/9/17 20:03
 * @UpdateRemark: 修改内容
 * @Version 1.0
 **/
@Service
public class GoodsBrandService {

    @Reference(version = "${dubbo.service.version}")
    private IApiGoodsBrandService apiGoodsBrandService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public GoodsBrand findById(Long id){
       return apiGoodsBrandService.findById(id);
    }

    /**
     * 查询所有
     * @return
     */
    public List<GoodsBrand> queryAll(){

        return apiGoodsBrandService.queryAll();
    }

    /**
     * 分页查询
     * @param brand
     * @param page
     * @param size
     * @return
     */
    public PageResult<GoodsBrand> queryByPage(GoodsBrand brand, Integer page, Integer size){
        return apiGoodsBrandService.queryByPage(brand,page,size);
    }

    /**
     * 新增
     * @param goodsBrand
     * @return
     */

    public Boolean add(GoodsBrand goodsBrand,List<Long> cids){

        return apiGoodsBrandService.add(goodsBrand,cids);
    }

    /**
     * 根据id删除品牌
     * @param id
     * @return
     */
    public Boolean delById(Long id){
        return  apiGoodsBrandService.delById(id);
    }

    /**
     *
     * @param brand  品牌
     * @param id     id
     * @return
     */
    public Boolean update(GoodsBrand brand,Long id,List<Long> cids){
        return apiGoodsBrandService.update(brand,id,cids);
    }



    public PageResult<GoodsBrand> findOfByPage(String key, int page, int rows, String sortBy, Boolean desc) {
        return  apiGoodsBrandService.findOfByPage(key,page,rows,sortBy,desc);
    }
}
