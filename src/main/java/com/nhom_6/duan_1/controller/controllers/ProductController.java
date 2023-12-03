package com.nhom_6.duan_1.controller.controllers;

import com.nhom_6.duan_1.model.entity.Product;
import com.nhom_6.duan_1.repository.ColorResponsitory;
import com.nhom_6.duan_1.repository.SizeResponsitory;
import com.nhom_6.duan_1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    SizeResponsitory sizeResponsitory;

    @Autowired
    ColorResponsitory colorResponsitory;

    @GetMapping
    public String product(Model model) {
        model.addAttribute("page", "shop");
        return "layout/index";
    }
    @GetMapping("/product-details")
    public String productDetail(Model model,@RequestParam("id") Long id) {
        model.addAttribute("sizes",sizeResponsitory.findAllByProduct_Id(id));
        model.addAttribute("product", productService.getById(id));
        model.addAttribute("page", "product-details");

        return "layout/index";
    }
    @GetMapping("/product-details/color-by-size")
    public ResponseEntity<?> getProductColorBySize(@RequestParam("sizeId") Long sizeId,
                                                   @RequestParam("productId") Long productId){
        try {
            System.out.println(sizeId);
            return ResponseEntity.ok(colorResponsitory.findAllByProduct_IdAndSize_Id(sizeId, productId));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }
}
