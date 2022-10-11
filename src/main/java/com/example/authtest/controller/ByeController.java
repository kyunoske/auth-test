package com.example.authtest.controller;

import lombok.extern.flogger.Flogger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bye")
public class ByeController {

    @GetMapping
    public String sayHello() {
        return "Bye bye people!";
    }
}
