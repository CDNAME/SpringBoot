package com.cd.springboot;

import com.cd.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	/*
	//不需要实现CommandLineRunner的方法
	public static void main(String[] args) {
		//返回了spring容器
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		UserService userService = (UserService) context.getBean("userServiceImpl");
		
		String hi = userService.sayHi("springboot java");
		System.out.println(hi);
	}
	*/

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		//启动springboot,启动spring容器
		SpringApplication springApplication = new SpringApplication(Application.class);
		springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.run(args);

		//SpringApplication.run(Application.class, args);
	}
	
	/**
	 * 相当于纯java程序的main方法
	 * 
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void run(String... args) throws Exception {
		String hi = userService.sayHi("Spring Boot Java");
		System.out.println(hi);
	}
}
