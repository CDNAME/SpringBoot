package com.cd.springboot.controller;

import com.cd.springboot.model.User;
import org.springframework.web.bind.annotation.*;

//@RestController相当于@Controller + @ResponseBody
@RestController
public class MVCController {
    
    @RequestMapping(value="/boot/getUser", method= RequestMethod.GET)
    public Object getUser() {
        User user = new User();
        user.setId(10);
        user.setName("王二");
        
        return user;
    }

    /*
    *   只支持GET请求
    *   @GetMapping = @RequestMapping + RequestMethod.GET
     */
    @GetMapping("/boot/getUser1")
    public Object getUser1() {
        User user = new User();
        user.setId(12);
        user.setName("王犯");
        
        return user;
    }

    /*
    *   只支持POST请求
    *   @GetMapping = @RequestMapping + RequestMethod.POST
     */
    @PostMapping("/boot/getUser2")
    public Object getUser2() {
        User user = new User();
        user.setId(10);
        user.setName("王二");
        
        return user;
    }
}
