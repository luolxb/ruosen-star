package com.ruosen.star.ruosenstar.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruosen.star.ruosenstar.module.po.Category;
import com.ruosen.star.ruosenstar.module.vo.CategoryRq;
import com.ruosen.star.ruosenstar.module.vo.CategoryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     CategoryRqMapper   
 *  * @package    com.ruosen.star.ruosenstar.dao  
 *  * @author Administrator     
 *  * @date   2019/10/6 0006 星期日
 *  * @version V1.0.0
 *  
 */
public interface CategoryMapper extends BaseMapper<Category> {

    /**
     * 获取品类分页
     *
     * @param categoryRq
     * @param page
     * @return
     */
    List<CategoryVo> getCategoryPage(@Param("conditions") CategoryRq categoryRq, Page page);

    /**
     * 根据产品ID获取品类
     *
     * @param id
     * @return
     */
    CategoryVo getDetailByProductId(Long id);
}
