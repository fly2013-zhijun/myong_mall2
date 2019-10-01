package myong.mall.manage.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import myong.mall.manage.goods.entity.GoodsBrand;
import myong.mall.manage.goods.mapper.GoodsBrandMapper;
import myong.mall.manage.goods.service.IBrandService;
import myong.mall.manage.vo.PageResult;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.function.Function;

/**
 * @ClassName GoodsServiceImpl
 * @Description TODO
 * @Author          flyong
 * @CreateDate
 * @UpdateUser
 * @UpdateDate: 2019/9/17 16:05
 * @UpdateRemark: 修改内容
 * @Version 1.0
 **/
@Slf4j
@Service
public class BrandServiceImpl implements IBrandService {

    @Autowired
    private GoodsBrandMapper goodsBrandMapper;

    @Override
    public Boolean add(GoodsBrand brand,List<Long> cids) {

        try {
            int insert = 0;
            insert = goodsBrandMapper.insert(brand);
            if(1 == insert && !CollectionUtils.isEmpty(cids)){
                int count = goodsBrandMapper.insertCategoryAndBrand(brand.getId(), cids);
                return  count >= 1;
            }
            return false;
        } catch (Exception e) {
            log.error("新增失败");
            e.printStackTrace();
            return  false;
        }

    }

    @Override
    public Boolean update(GoodsBrand brand,Long id,List<Long> cids) {
        brand.setId(id);
        int update = 0;
        try {
            update = goodsBrandMapper.updateByPrimaryKey(brand); //更新品牌信息
            if(1 == update) { //如果更新成功更新品牌分类关联表
                List<Long> oldCids = findCategoryIdsByBrandId(id); //根据品牌id获取关联的cid的集合
                if(!CollectionUtils.isEqualCollection(oldCids,cids)){ //判断两个集合是否相等
                    //不相等删除以前的关联关系
                    int del = goodsBrandMapper.delCategoryAssociationBrandByBrandId(id);

                    if(del > 0){ //删除成功
                       return  goodsBrandMapper.insertCategoryAndBrand(id,cids) > 0; //重新插入
                    }
                    return  false;
                }
            }
            return  true;

        } catch (Exception e) {
            log.error("更新失败");
            e.printStackTrace();
            return  false;
        }

    }

    @Override
    public Boolean delById(Long id) {
        GoodsBrand goodsBrand = new GoodsBrand();
        goodsBrand.setId(id);
        goodsBrand.setShowStatus(0);
        int del = 0;
        try {

            del = goodsBrandMapper.updateByPrimaryKeySelective(goodsBrand);
        } catch (Exception e) {
            log.error("删除失败");
            e.printStackTrace();
        }
        return 1 == del;
    }

    @Override
    public GoodsBrand findById(Long id) {


        Function<Long,GoodsBrand> function = x -> (new GoodsBrand().setId(x));

        return goodsBrandMapper.selectOne(function.apply(id));



    }

    @Override
    public List<GoodsBrand> queryAll() {
        return goodsBrandMapper.selectAll();
    }

    @Override
    public PageResult<GoodsBrand> queryByPage(GoodsBrand record, Integer page, Integer size) {
        //设置分页查询的参数
        PageHelper.startPage(page,size);
        //创建分页查询的条件对象
        Example example = new Example(GoodsBrand.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(record.getName())){

            criteria.andLike("name",
                    StringUtils.join("%",record.getName(),"%"));

        }

        //根据排序字段和品牌首字母升序排列
        example.setOrderByClause(StringUtils.join("sort"," ","asc",",","first_letter"," ","asc"));

        //获取分页结果集
        List<GoodsBrand> goodsBrands = goodsBrandMapper.selectByExample(example);


        //根据分页结果集获取分页对象
        PageInfo<GoodsBrand> pageInfo = new PageInfo<>(goodsBrands);

        //返回分页封装对象
        return new PageResult<GoodsBrand>(page,size,pageInfo.getTotal(),pageInfo.getList());

    }

    @Override
    public PageResult<GoodsBrand> findOfByPage(String key, int page, int rows, String sortBy, Boolean desc) {
        PageHelper.startPage(page,rows);
        Example example = new Example(GoodsBrand.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(key)){
            try {
                criteria.andLike("name",StringUtils.join("%",key,"%"))
                        .orEqualTo("firstLetter",key);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        String orderBy = desc ? "asc" : "desc";
        example.setOrderByClause(StringUtils.join(sortBy," ",orderBy));
        List<GoodsBrand> goodsBrands = goodsBrandMapper.selectByExample(example);
        PageInfo<GoodsBrand> pageInfo = new PageInfo<>(goodsBrands);
        return  new PageResult<GoodsBrand>(page,rows,pageInfo.getTotal(),pageInfo.getList());
    }

    @Override
    public List<Long> findCategoryIdsByBrandId(Long id) {
        return goodsBrandMapper.findBrandAssociationCategoryIds(id);
    }
}
