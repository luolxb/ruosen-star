package com.ruosen.star.ruosenstar.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruosen.star.ruosenstar.dao.CategoryProductMapper;
import com.ruosen.star.ruosenstar.module.po.CategoryProduct;
import com.ruosen.star.ruosenstar.service.CategoryProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     CategoryProductServiceImpl   
 *  * @package    com.ruosen.star.ruosenstar.service.impl  
 *  * @author Administrator     
 *  * @date   2019/10/7 0007 星期一
 *  * @version V1.0.0
 *  
 */
@Slf4j
@Service
public class CategoryProductServiceImpl extends ServiceImpl<CategoryProductMapper, CategoryProduct>
        implements CategoryProductService {
}
