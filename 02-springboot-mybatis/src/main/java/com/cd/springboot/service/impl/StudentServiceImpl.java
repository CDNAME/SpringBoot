package com.cd.springboot.service.impl;

import com.cd.springboot.mapper.StudentMapper;
import com.cd.springboot.model.Student;
import com.cd.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    
    @Autowired
    private StudentMapper studentMapper;

    //注入springboot自动配置好的RedisTemplate
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
    //springboot帮我们注入的RedisTemplate类，泛型里面只能写<Object, Object>，<String, String>
    //private RedisTemplate<String, String> redisTemplate2;

    @Override
    public/*synchronized*/ List<Student> getAllStudent() {
        //字符串的序列化器,让key可读性好一些
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);

        //高并发条件下，此处有点问题：缓存穿透
        //查询缓存
        List<Student> studentList = (List<Student>) redisTemplate.opsForValue().get("allStudents");
        
        //双重检测锁
        if (null == studentList) {
            synchronized (this) {
                //从redis中再获取一次
                studentList = (List<Student>) redisTemplate.opsForValue().get("allStudents");

                if (null == studentList) {
                    System.out.println("查询数据库......");
                    //缓存为空，查询一遍数据库
                    studentList = studentMapper.selectAllStudent();
                    //把数据库查询出来的数据,放入redis中
                    redisTemplate.opsForValue().set("allStudents", studentList);
                } else {
                    System.out.println("查询缓存锁内......");
                }
            }
        } else {
            System.out.println("查询缓存锁外......");
        }
        return studentList;
    }

    @Transactional
    @Override
    public int update() {
        Student student = new Student();
        student.setId(1);
        student.setName("李四-update");
        student.setAge(18);
        int update = studentMapper.updateStudent(student);
        System.out.println("更新结果：" + update);

        //除数不能为0，所以此处会抛出一个运行时的异常，上一步的更新就会回滚@Transactional
        //int a = 10/0;

        return update;
    }
}
