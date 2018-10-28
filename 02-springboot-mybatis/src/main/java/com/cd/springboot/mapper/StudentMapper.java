package com.cd.springboot.mapper;

import com.cd.springboot.model.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> selectAllStudent();

    int updateStudent(Student student);
}
