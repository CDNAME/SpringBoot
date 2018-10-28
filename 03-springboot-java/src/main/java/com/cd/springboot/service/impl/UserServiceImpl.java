package com.cd.springboot.service.impl;

import com.cd.springboot.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public String sayHi(String name) {
        return "Hi, " + name;
    }
}
