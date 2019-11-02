package com.ruosen.star.ruosenstar.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruosen.star.ruosenstar.module.po.Product;
import com.ruosen.star.ruosenstar.module.vo.ProductRq;
import com.ruosen.star.ruosenstar.module.vo.ProductVo;
import com.ruosen.star.ruosenstar.utils.PageInfo;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     ProductService   
 *  * @package    com.ruosen.star.ruosenstar.service  
 *  * @author Administrator     
 *  * @date   2019/10/7 0007 星期一
 *  * @version V1.0.0
 *  
 */
public interface ProductService extends IService<Product> {

    /**
     * 获取产品分页
     *
     * @param productRq
     * @param pageInfo
     * @return
     */
    Page<ProductVo> getProductPage(ProductRq productRq, PageInfo pageInfo);

    /**
     * 修改产品信息
     *
     * @param productRq
     */
    void update(ProductRq productRq);
}
