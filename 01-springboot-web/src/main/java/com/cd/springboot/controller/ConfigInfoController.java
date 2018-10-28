package com.cd.springboot.controller;

import com.cd.springboot.config.ConfigInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConfigInfoController {
    
    @Value("${boot.name}")
    private String name;
    
    @Value("${boot.location}")
    private String location;
    
    @Autowired
    private ConfigInfo configInfo;
    
    @RequestMapping("/boot/config")
    public @ResponseBody String configInfo() {
        return name + "-----" + location + "; " + configInfo.getName() + "----" + configInfo.getLocation();
    }
}
