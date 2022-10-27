package com.office.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages= {"com.office"})
@EntityScan("com.office.entity")
@EnableJpaRepositories("com.office.repository")
public class Step3Application {

	public static void main(String[] args) {
		SpringApplication.run(Step3Application.class, args);
		System.out.println("START");

	}

}
