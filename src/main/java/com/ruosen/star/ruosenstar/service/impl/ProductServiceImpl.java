package com.ruosen.star.ruosenstar.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruosen.star.ruosenstar.dao.ProductMapper;
import com.ruosen.star.ruosenstar.module.po.AttachmentAssociated;
import com.ruosen.star.ruosenstar.module.po.Category;
import com.ruosen.star.ruosenstar.module.po.Product;
import com.ruosen.star.ruosenstar.module.vo.AttachmentVo;
import com.ruosen.star.ruosenstar.module.vo.CategoryVo;
import com.ruosen.star.ruosenstar.module.vo.ProductRq;
import com.ruosen.star.ruosenstar.module.vo.ProductVo;
import com.ruosen.star.ruosenstar.service.AttachmentService;
import com.ruosen.star.ruosenstar.service.CategoryService;
import com.ruosen.star.ruosenstar.service.ProductService;
import com.ruosen.star.ruosenstar.utils.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     ProductServiceImpl   
 *  * @package    com.ruosen.star.ruosenstar.service.impl  
 *  * @author Administrator     
 *  * @date   2019/10/7 0007 星期一
 *  * @version V1.0.0
 *  
 */
@Service
@Slf4j
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AttachmentService attachmentService;

    /**
     * 获取产品分页
     *
     * @param productRq
     * @param pageInfo
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ProductVo> getProductPage(ProductRq productRq, PageInfo pageInfo) {
        Page<ProductVo> page = new Page<>(pageInfo.getCurrent(), pageInfo.getSize());
        List<ProductVo> productVoList = this.baseMapper.getProductPage(productRq, page);
        productVoList.forEach(productVo -> {
            getProductCategory(productVo);
            // 获取附件
            getAttachmentVo(productVo);
        });
        return page.setRecords(productVoList);
    }

    /**
     * 获取产品品类
     *
     * @param productVo
     */
    private void getProductCategory(ProductVo productVo) {
        // 获取品类
        productVo.setCategoryVo(categoryService.getDetailByProductId(productVo.getId()));
        if (StringUtils.isNotBlank(productVo.getCategoryVo().getParentCode())) {
            QueryWrapper<Category> wrapper = new QueryWrapper<>();
            CategoryVo categoryVo = new CategoryVo();
            wrapper.eq("category_code", productVo.getCategoryVo().getParentCode());
            Category category = categoryService.getOne(wrapper);
            BeanUtils.copyProperties(category, categoryVo);
            productVo.setParentCategoryVo(categoryVo);
        }
    }

    /**
     * 获取附件
     *
     * @param productVo
     */
    private void getAttachmentVo(ProductVo productVo) {
        AttachmentAssociated attachmentAssociated = new AttachmentAssociated();
        attachmentAssociated.setModuleId(productVo.getId());
        List<AttachmentVo> attachmentVoList = attachmentService.getAttachmentVoList(attachmentAssociated);
        productVo.setAttachmentVos(attachmentVoList);
    }

    /**
     * 修改产品信息
     *
     * @param productRq
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ProductRq productRq) {
        Product product = new Product();
        BeanUtils.copyProperties(productRq, product);
        this.baseMapper.updateById(product);
    }
}
