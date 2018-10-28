package com.cd.springboot.controller;

import com.cd.springboot.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestFullController {
    
    //  http://localhost:8080/01-springboot-web/boot/user/106
    @RequestMapping("/boot/user/{id}")
    public Object user(@PathVariable("id") Integer id) {
        User user = new User();
        user.setId(id);
        user.setName("王犯");
        
        return user;
    }
    
    //  http://localhost:8080/01-springboot-web/boot/user/106/wangfan
    @RequestMapping("/boot/user/{id}/{name}")
    public Object user(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
         
        return user;
    }

    //  http://localhost:8080/01-springboot-web/boot/wangfan/user/106
    @RequestMapping("/boot/{name}/user/{id}")
    public Object user2(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
         
        return user;
    }
}
