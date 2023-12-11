package com.nhom_6.duan_1.controller.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Login {
    @GetMapping("/login")
    public String loginPage(){
        return "/web/login";
    }
}
