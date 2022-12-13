package in.triton.all.configure;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import in.triton.all.filter.LoginFilter;
import in.triton.all.jwt.JwtAuthFilter;


@EnableWebSecurity
@EnableMethodSecurity
@Configuration
public class SecurityConfigure {

	
	@Autowired
	@Lazy
	LoginFilter loginFilter;
	
	@Autowired
	@Lazy
	JwtAuthFilter authFilter;
	
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	AuthenticationManager authenticationManager(UserDetailsService detailsService) {
		DaoAuthenticationProvider daoProvider=new DaoAuthenticationProvider();
		daoProvider.setUserDetailsService(detailsService);
		daoProvider.setPasswordEncoder(passwordEncoder());
		return new ProviderManager(daoProvider);
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeHttpRequests().requestMatchers("/api/v1/student/").hasAnyAuthority("ADMIN","STUDENT");
		http.httpBasic();
		http.addFilterAt(loginFilter, BasicAuthenticationFilter.class);
		http.addFilterAfter(authFilter, BasicAuthenticationFilter.class);
		return http.build();
	}
}
