package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class AuthenticationController {
    @GetMapping("/login")
    public String showLoginForm() {
        return "/user/login";
    }
}