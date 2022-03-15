package com.github.amangupta00.demo.springboot;

import com.github.amangupta00.demo.springboot.model.User;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@MappedTypes(User.class)
@MapperScan("com.github.amangupta00.demo.springboot.dao")
@SpringBootApplication
@EnableCaching
public class DemoSpringBootApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBootApplication.class, args);
	}

}
