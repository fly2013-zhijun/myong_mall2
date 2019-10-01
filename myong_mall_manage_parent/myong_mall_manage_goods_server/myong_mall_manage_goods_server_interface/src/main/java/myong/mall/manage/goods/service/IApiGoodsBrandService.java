package myong.mall.manage.goods.service;

import myong.mall.manage.goods.entity.GoodsBrand;
import myong.mall.manage.vo.PageResult;

import java.util.List;

/**
 * @ClassName IApiGoodsService      商品品牌业务接口类
 * @Description TODO
 * @Author
 * @CreateDate
 * @UpdateUser
 * @UpdateDate: 2019/9/17 11:59
 * @UpdateRemark: 修改内容
 * @Version 1.0
 **/
public interface IApiGoodsBrandService{
    /**
     * 新增
     * @param brand
     * @return
     */
    public Boolean add(GoodsBrand brand,List<Long> cids);

    /**
     * 更新
     * @param brand
     * @return
     */
    public Boolean update(GoodsBrand brand,Long id,List<Long> cids);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    public Boolean delById(Long id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public GoodsBrand findById(Long id);

    /**
     * 查询所有
     * @return
     */
    public List<GoodsBrand> queryAll();     // 查询所有

    /**
     * 分页条件查询
     * @param   record
     * @param   page
     * @param   size
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
}
