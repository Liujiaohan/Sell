package com.liujiaohan.sell.controller;

import com.liujiaohan.sell.utils.ResultVOUtil;
import com.liujiaohan.sell.VO.ProductInfoVO;
import com.liujiaohan.sell.VO.ProductVO;
import com.liujiaohan.sell.VO.ResultVO;
import com.liujiaohan.sell.dataobject.ProductCategory;
import com.liujiaohan.sell.dataobject.ProductInfo;

import com.liujiaohan.sell.service.impI.CategoryServiceImpl;
import com.liujiaohan.sell.service.impI.ProductInfoServiceImpl;
import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping("/list")
    public ResultVO list(){
        //查询所有上架商品
        List<ProductInfo> productInfoList=productInfoService.findUpAll();

        //查询类目（一次性查询
        List<Integer> categoryTypeList=new ArrayList<>();
        for (ProductInfo productInfo:productInfoList
             ) {
            categoryTypeList.add(productInfo.getCategoryType());
        }
        List<ProductCategory> productCategories=categoryService.findByCategoryTypeIn(categoryTypeList);

        //数据拼装
        List<ProductVO> productVOS=new ArrayList<>();
        for (ProductCategory productCategory:productCategories
             ) {
            ProductVO productVO=new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOS=new ArrayList<>();

            for (ProductInfo productInfo:productInfoList
                    ){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO=new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOS.add(productInfoVO);
                }
                productVO.setFoods(productInfoVOS);
            }
            productVOS.add(productVO);
        }
        return ResultVOUtil.success(productVOS);
    }
}
