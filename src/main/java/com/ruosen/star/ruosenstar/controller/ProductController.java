package com.ruosen.star.ruosenstar.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruosen.star.ruosenstar.module.base.ResponseData;
import com.ruosen.star.ruosenstar.module.vo.ProductRq;
import com.ruosen.star.ruosenstar.module.vo.ProductVo;
import com.ruosen.star.ruosenstar.service.ProductService;
import com.ruosen.star.ruosenstar.utils.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     ProductController   
 *  * @package    com.ruosen.star.ruosenstar.controller  
 *  * @author Administrator     
 *  * @date   2019/10/7 0007 星期一
 *  * @version V1.0.0
 *  
 */
@RestController
@RequestMapping("/product")
@Api(tags = "产品")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/getPage")
    @ApiOperation("获取产品分页")
    public ResponseData getPage(@RequestBody(required = false) ProductRq productRq,
                                PageInfo pageInfo) {
        Page<ProductVo> productPage = productService.getProductPage(productRq, pageInfo);
        return new ResponseData().ok(productPage);
    }

    @PostMapping("/update")
    @ApiOperation("修改产品信息")
    public ResponseData update(@RequestBody ProductRq productRq) {
        productService.update(productRq);

        return new ResponseData().ok();
    }
}
