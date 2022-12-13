package in.triton.all;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import in.triton.all.entity.GetData;
import jakarta.servlet.http.HttpServletRequest;

@SpringBootApplication
@ComponentScan("in.triton.all")
public class AllConceptsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllConceptsApplication.class, args);
		System.out.println("START");
		
	
			
	}

}
