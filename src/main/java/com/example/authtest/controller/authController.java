package com.example.authtest.controller;

import com.example.authtest.model.AppUser;
import com.example.authtest.service.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class authController {

    private final AppUserDetailsService service;

    @Autowired
    public authController(AppUserDetailsService service) {
        this.service = service;
    }

    @GetMapping
    public String sayHello() {
        return "Hello people!";
    }

//    @GetMapping
//    public List<AppUser> getAllUsers() {
//        return service.getAllUsers();
//    }

    @PostMapping
    public AppUser addUser(@RequestBody AppUser user) {
        return service.addUser(user);
    }
}
