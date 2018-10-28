package com.cd.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = {"com.cd.springboot.servlet", "com.cd.springboot.filter"})
public class Application {

	public static void main(String[] args) {
//		启动了springboot程序，启动spring容器，启动内嵌的tomcat
		SpringApplication.run(Application.class, args);
	}
}
