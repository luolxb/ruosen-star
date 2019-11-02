package com.ruosen.star.ruosenstar.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruosen.star.ruosenstar.module.po.Category;
import com.ruosen.star.ruosenstar.module.vo.CategoryRq;
import com.ruosen.star.ruosenstar.module.vo.CategoryVo;
import com.ruosen.star.ruosenstar.utils.PageInfo;

import java.util.List;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     CategoryService   
 *  * @package    com.ruosen.star.ruosenstar.service  
 *  * @author Administrator     
 *  * @date   2019/10/6 0006 星期日
 *  * @version V1.0.0
 *  
 */
public interface CategoryService extends IService<Category> {


    /**
     * 获取品类分页
     *
     * @param categoryRq
     * @param pageInfo
     * @return
     */
    Page<CategoryVo> getCategoryPage(CategoryRq categoryRq, PageInfo pageInfo);

    /**
     * 新增品类
     *
     * @param categoryRq
     */
    void add(CategoryRq categoryRq);

    /**
     * 修改品类
     *
     * @param categoryRq
     */
    void update(CategoryRq categoryRq);

    /**
     * 根据ids 删除品类
     *
     * @param ids
     */
    void deleteByids(List<Long> ids);

    /**
     * 获取详情
     *
     * @param id
     * @return
     */
    CategoryVo detail(Long id);

    /**
     * 根据产品id获取品类详情
     *
     * @param id
     * @return
     */
    CategoryVo getDetailByProductId(Long id);

}
