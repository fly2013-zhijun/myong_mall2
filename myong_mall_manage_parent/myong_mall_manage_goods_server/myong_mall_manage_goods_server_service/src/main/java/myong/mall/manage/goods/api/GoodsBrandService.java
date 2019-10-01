package myong.mall.manage.goods.api;

import com.alibaba.dubbo.config.annotation.Service;
import myong.mall.manage.goods.entity.GoodsBrand;
import myong.mall.manage.goods.service.IApiGoodsBrandService;
import myong.mall.manage.goods.service.IBrandService;
import myong.mall.manage.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName GoodsBrandService  业务api接口实现类(服务提供者)
 * @Description TODO
 * @Author          flyong
 * @CreateDate
 * @UpdateUser
 * @UpdateDate: 2019/9/17 19:42
 * @UpdateRemark: 修改内容
 * @Version 1.0
 **/
@Service(version = "${dubbo.service.version}")
public class GoodsBrandService implements IApiGoodsBrandService {

    @Autowired
    private IBrandService brandService;

    @Override
    public Boolean add(GoodsBrand brand,List<Long> cids) {
        return brandService.add(brand,cids);
    }

    @Override
    public Boolean update(GoodsBrand brand,Long id,List<Long> cids) {
        return brandService.update(brand,id,cids);
    }

    @Override
    public Boolean delById(Long id) {
        return brandService.delById(id);
    }

    @Override
    public GoodsBrand findById(Long id) {
        return brandService.findById(id);
    }

    @Override
    public List<GoodsBrand> queryAll() {
        return brandService.queryAll();
    }

    @Override
    public PageResult<GoodsBrand> queryByPage(GoodsBrand record, Integer page, Integer size) {
        return brandService.queryByPage(record,page,size);
    }

    @Override
    public PageResult<GoodsBrand> findOfByPage(String key, int page, int rows, String sortBy, Boolean desc) {
        return brandService.findOfByPage(key,page,rows,sortBy,desc);
    }

}

