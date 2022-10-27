package in.tritonlabs.adharcard.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("in.tritonlabs.adharcard")
@EnableJpaRepositories("in.tritonlabs.adharcard.repository")
@EntityScan("in.tritonlabs.adharcard.entity")
public class UndirectionalOneToOnePracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(UndirectionalOneToOnePracticeApplication.class, args);
		System.out.println("SERVER START");
	}

}
