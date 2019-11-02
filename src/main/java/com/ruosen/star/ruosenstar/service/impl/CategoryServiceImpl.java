package com.ruosen.star.ruosenstar.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruosen.star.ruosenstar.dao.CategoryMapper;
import com.ruosen.star.ruosenstar.module.po.Category;
import com.ruosen.star.ruosenstar.module.vo.CategoryRq;
import com.ruosen.star.ruosenstar.module.vo.CategoryVo;
import com.ruosen.star.ruosenstar.service.CategoryService;
import com.ruosen.star.ruosenstar.service.CommonSequenceService;
import com.ruosen.star.ruosenstar.utils.PageInfo;
import com.ruosen.star.ruosenstar.utils.RequestHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     CategoryServiceImpl   
 *  * @package    com.ruosen.star.ruosenstar.service.impl  
 *  * @author Administrator     
 *  * @date   2019/10/6 0006 星期日
 *  * @version V1.0.0
 *  
 */
@Service
@Slf4j
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private CommonSequenceService commonSequenceService;

    /**
     * 获取品类分页
     *
     * @param categoryRq
     * @param pageInfo
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public Page<CategoryVo> getCategoryPage(CategoryRq categoryRq, PageInfo pageInfo) {

        Page<CategoryVo> page = new Page<>(pageInfo.getCurrent(), pageInfo.getSize());
        List<CategoryVo> categoryPage = this.baseMapper.getCategoryPage(categoryRq, page);
        page.setRecords(categoryPage);
        return page;
    }

    /**
     * 新增品类
     *
     * @param categoryRq
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(CategoryRq categoryRq) {
        String categoryCode = commonSequenceService.generate("C_", "yyyyMMdd", 10);
        Category category = new Category();
        BeanUtils.copyProperties(categoryRq, category);
        category.setCategoryCode(categoryCode);
        category.setCreateDate(new Date());
        category.setCreateBy(RequestHandler.getDefaultUserName());
        if (StringUtils.isBlank(category.getParentCode())) {
            category.setParentCode(null);
        }
        this.baseMapper.insert(category);
    }

    /**
     * 修改品类
     *
     * @param categoryRq
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(CategoryRq categoryRq) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryRq, category);
        category.setUpdateBy(RequestHandler.getDefaultUserName());
        category.setUpdateDate(new Date());
        category.setCategoryCode(null);
        this.baseMapper.updateById(category);
    }

    /**
     * 根据ids 删除品类
     *
     * @param ids
     */
    @Override
    public void deleteByids(List<Long> ids) {
        this.baseMapper.deleteBatchIds(ids);
    }

    /**
     * 获取详情
     *
     * @param id
     * @return
     */
    @Override
    public CategoryVo detail(Long id) {
        Category category = this.baseMapper.selectById(id);
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category, categoryVo);
        return categoryVo;
    }

    /**
     * 根据产品id获取品类详情
     *
     * @param id
     * @return
     */
    @Override
    public CategoryVo getDetailByProductId(Long id) {
        return this.baseMapper.getDetailByProductId(id);
    }
}
