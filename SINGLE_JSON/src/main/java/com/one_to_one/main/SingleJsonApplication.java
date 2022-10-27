package com.one_to_one.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.one_to_one")
@EntityScan("com.one_to_one.entity")
@EnableJpaRepositories("com.one_to_one.repository")
public class SingleJsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SingleJsonApplication.class, args);
		System.out.println("START");
	}

}
