package com.ruosen.star.ruosenstar.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruosen.star.ruosenstar.module.po.Product;
import com.ruosen.star.ruosenstar.module.vo.ProductRq;
import com.ruosen.star.ruosenstar.module.vo.ProductVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     ProductMapper   
 *  * @package    com.ruosen.star.ruosenstar.dao  
 *  * @author Administrator     
 *  * @date   2019/10/7 0007 星期一
 *  * @version V1.0.0
 *  
 */
public interface ProductMapper extends BaseMapper<Product> {

    /**
     * 获取产品分页
     *
     * @param productRq
     * @param Page
     * @return
     */
    List<ProductVo> getProductPage(@Param("productRq") ProductRq productRq, Page Page);
}
