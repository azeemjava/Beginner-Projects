package com.cd.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.cd")
@EntityScan("com.cd.entity")
@EnableJpaRepositories("com.cd.repository")
public class CollegeAndDailyTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollegeAndDailyTaskApplication.class, args);
		System.out.println("START");
	}

}
