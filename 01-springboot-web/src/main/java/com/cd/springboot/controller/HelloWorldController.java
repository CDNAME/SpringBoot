package com.cd.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    
    @RequestMapping("/boot")
    public String sayHello() {
        return "Hello, SpringBoot!";
    }
}
