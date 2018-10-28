package com.cd.springboot.service;

import com.cd.springboot.model.Student;

import java.util.List;

public interface StudentService {
    
    List<Student> getAllStudent();
    
    int update();
}
