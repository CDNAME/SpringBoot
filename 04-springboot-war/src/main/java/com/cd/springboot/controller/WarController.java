package com.cd.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class WarController {
    
    @RequestMapping("/boot/json")
    public @ResponseBody Object json() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "陈登");
        map.put("address", "陈庄");
        
        return map;
    }

    @RequestMapping("/boot/jsp")
    public String jsp(Model model) {
        model.addAttribute("address", "陈庄");
        
        return "/index.jsp";
    }
}
