package myong.mall.manage.goods.service;

import myong.mall.manage.goods.entity.GoodsBrand;
import myong.mall.manage.vo.PageResult;

import java.util.List;

/**
 * @ClassName IGoodsService         商品业务接口
 * @Description TODO
 * @Author          flyong
 * @CreateDate
 * @UpdateUser
 * @UpdateDate: 2019/9/17 13:04
 * @UpdateRemark: 修改内容
 * @Version 1.0
 **/
public interface IBrandService {

    /**
     * 新增品牌
     * @param brand     品牌对象
     * @param cids      品牌关联的分类id集合
     * @return
     */
    public Boolean add(GoodsBrand brand,List<Long> cids);

    /**
     * 更新品牌信息
     * @param brand
     * @return
     */
    public Boolean update(GoodsBrand brand,Long id,List<Long> cids);    //更新

    /**
     * 根据id删除品牌
     * @param id
     * @return
     */
    public Boolean delById(Long id);            //根据id删除

    /**
     * 根据id获取品牌信息
     * @param id
     * @return
     */
    public GoodsBrand findById(Long id);    //根据id查询

    /**
     * 查询所有
     * @return
     */
    public List<GoodsBrand> queryAll();     // 查询所有

    /**
     * 分页条件查询
     * @param record
     * @param page
     * @param size
     * @return
     */
    public PageResult<GoodsBrand> queryByPage(GoodsBrand record, Integer page, Integer size);


    /**
     * 分页条件查询
     * @param key    搜索关键字
     * @param page   当前页面
     * @param rows      页面容量
     * @param sortBy        排序字段
     * @param desc          是否降序排列
     * @return
     */
    public PageResult<GoodsBrand> findOfByPage(String key, int page, int rows, String sortBy, Boolean desc);

    /**
     * 根据品牌id查询关联的商品分类的三级id
     * @param id
     * @return
     */
    public List<Long> findCategoryIdsByBrandId(Long id);

}
