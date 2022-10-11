package com.example.authtest.controller;

import com.example.authtest.service.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class adminController {

    @GetMapping
    public String admin() {
        return "Are you an admin?";
    }
}
