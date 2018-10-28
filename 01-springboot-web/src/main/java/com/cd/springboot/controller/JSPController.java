package com.cd.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JSPController {
    
    @GetMapping("/boot/index")
    public String index(Model model) {
        model.addAttribute("msg", "Spring Boot 集成JSP.");
        return "/index.jsp";
    }
    
}
