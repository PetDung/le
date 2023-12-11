package com.nhom_6.duan_1.controller.controllers;

import com.nhom_6.duan_1.model.entity.Bill;
import com.nhom_6.duan_1.model.entity.User;
import com.nhom_6.duan_1.service.BillService;
import com.nhom_6.duan_1.service.UserService;
import com.nhom_6.duan_1.serviceImp.BillServiceImp;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/shopping-cart")
public class ShoppingCartController {

    @Autowired
    BillServiceImp billService;

    @Autowired
    UserService userService;

    @GetMapping
    public String shoppingCart(Model model, HttpSession session) {
        User user = userService.getLogin(session);
        System.out.println("id " + user.getId());
        model.addAttribute("page", "shopping-cart");
        Bill bill = billService.getCartByUserId(user.getId());
        if(bill == null){
            bill = new Bill();
        }
        model.addAttribute("cart", bill);
        return "/layout/index";
    }
}
