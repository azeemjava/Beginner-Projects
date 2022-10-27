package com.practice.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.practice.entity")
@EnableJpaRepositories("com.practice.repository")
@ComponentScan("com.practice")
public class SpringbootWithQueryApplication {

	public static void main(String[] args) {
	
		SpringApplication.run(SpringbootWithQueryApplication.class, args);

		System.out.println("START");
	}
	

}
