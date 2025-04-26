package com.autohuolto.autohuolto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @GetMapping("/create-account")
    public String createAccountPage() {
        return "create-account";  // Make sure you have a 'create-account.html' template
    }
}
