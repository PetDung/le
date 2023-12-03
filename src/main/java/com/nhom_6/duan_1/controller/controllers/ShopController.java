package com.nhom_6.duan_1.controller.controllers;

import com.nhom_6.duan_1.model.entity.*;
import com.nhom_6.duan_1.serviceImp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ProductSeviceImp productSeviceImp;
    @Autowired
    private CategoryServiceImp categoryServiceImp;
    @Autowired
    private ProductDetailsServiceImp productDetailsServiceImp;
    @Autowired
    private ColorServiceImp colorServiceImp;

    @GetMapping("")
    public String shop(@RequestParam(name = "category", required = false) Long category,
                       @RequestParam(name = "start", required = false) Integer start,
                       @RequestParam(name = "end", required = false) Integer end,
                       @RequestParam(name = "color",required = false) Long color, Model model) {


        List<Product> list;
        list = productSeviceImp.getAll();

        if(category!= null) {
            list = productSeviceImp.getProductsByCategoryId(category);
        }
        else if(end != null && start !=null) {
            list =productSeviceImp.getProductByPrice(start,end);
        }
        else if(color!=null) {
            list =productSeviceImp.getProductByColor(color);
        }

        model.addAttribute("page", "shop");
        model.addAttribute("listCategory", categoryServiceImp.getAll());
        model.addAttribute("listColor", colorServiceImp.getAll());
        model.addAttribute("listProduct", list);

        return "layout/index";
    }
}
