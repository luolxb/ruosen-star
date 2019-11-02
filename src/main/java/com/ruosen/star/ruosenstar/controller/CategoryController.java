package com.ruosen.star.ruosenstar.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruosen.star.ruosenstar.module.base.ResponseData;
import com.ruosen.star.ruosenstar.module.vo.CategoryRq;
import com.ruosen.star.ruosenstar.module.vo.CategoryVo;
import com.ruosen.star.ruosenstar.service.CategoryService;
import com.ruosen.star.ruosenstar.utils.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     CategoryController   
 *  * @package    com.ruosen.star.ruosenstar.controller  
 *  * @author Administrator     
 *  * @date   2019/10/6 0006 星期日
 *  * @version V1.0.0
 *  
 */
@RestController
@Slf4j
@RequestMapping("/category")
@Api(tags = "品类")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    @ApiOperation("新增品类")
    public ResponseData addCategory(@Valid @RequestBody CategoryRq categoryRq,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseData().error(bindingResult.getFieldError().getDefaultMessage());
        }
        categoryService.add(categoryRq);
        return new ResponseData().ok();
    }

    @PutMapping("/update")
    @ApiOperation("修改品类")
    public ResponseData updateCategory(@Valid @RequestBody CategoryRq categoryRq,
                                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseData().error(bindingResult.getFieldError().getDefaultMessage());
        }
        categoryService.update(categoryRq);
        return new ResponseData().ok();
    }

    @ApiOperation(value = "获取品类分页")
    @PostMapping("/getPage")
    public ResponseData getCategoryPage(@RequestBody(required = false) CategoryRq categoryRq,
                                        PageInfo pageInfo) {

        Page<CategoryVo> page = categoryService.getCategoryPage(categoryRq, pageInfo);
        return new ResponseData().ok(page);
    }

    @ApiOperation(value = "删除品类")
    @DeleteMapping("/delete")
    public ResponseData delete(@RequestParam List<Long> ids) {
        categoryService.deleteByids(ids);
        return new ResponseData().ok();
    }

    @ApiOperation(value = "获取详情")
    @GetMapping("/detail")
    public ResponseData detail(@RequestParam("id") Long id) {
        CategoryVo detail = categoryService.detail(id);
        return new ResponseData().ok(detail);
    }
}
