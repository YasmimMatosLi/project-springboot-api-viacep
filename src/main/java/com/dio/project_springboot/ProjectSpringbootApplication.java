package com.dio.project_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ProjectSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectSpringbootApplication.class, args);
	}

}
