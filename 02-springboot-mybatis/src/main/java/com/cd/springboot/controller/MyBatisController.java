package com.cd.springboot.controller;

import com.cd.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class MyBatisController {
    
    @Autowired
    private StudentService studentService;
    
    @GetMapping("/boot/students")
    public Object students() {
        //多线程测试缓存穿透问题
        ExecutorService service = Executors.newFixedThreadPool(25);
        for (int i = 0; i < 10000; i++) {
            service.submit(()->{
                studentService.getAllStudent();
            });
        }
        return studentService.getAllStudent();
    }

    @GetMapping("/boot/update")
    public Object update() {
        return studentService.update();
    }
}
