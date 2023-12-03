package com.nhom_6.duan_1.controller.controllers;

import com.nhom_6.duan_1.model.entity.User;
import com.nhom_6.duan_1.service.BillService;
import com.nhom_6.duan_1.service.UserService;
import com.nhom_6.duan_1.serviceImp.BillServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

    @Autowired
    BillServiceImp billService;

    @Autowired
    UserService userService;

    @GetMapping
    public String shoppingCart(Model model) {
        User user = userService.getLogin();
        model.addAttribute("page", "shopping-cart");
        model.addAttribute("cart", billService.getCartByUserId(user.getId()));
        return "layout/index";
    }
}
