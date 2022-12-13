package in.triton.all.filter;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import in.triton.all.entity.GetData;
import in.triton.all.jwt.JwtAuthHelper;
import in.triton.all.service.impl.StudentServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoginFilter extends OncePerRequestFilter {
	
	@Autowired
	StudentServiceImpl impl;

	@Autowired
	private  AuthenticationManager authenticationManager;
	
	@Autowired
	JwtAuthHelper authHelper;

		
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {


		String username = request.getHeader("username");
		String password = request.getHeader("password");
		
		impl.getData(username, password);
	
		Authentication authenticated = authenticationManager.authenticate(

					new UsernamePasswordAuthenticationToken(username, password));


		response.setHeader(HttpHeaders.AUTHORIZATION, generateJwtAuthToken(authenticated));
	}	

	private String generateJwtAuthToken(Authentication authentication) {

		User user = (User) authentication.getPrincipal();
		String roles = user.getAuthorities()
				        .stream()
			        	.map(GrantedAuthority::getAuthority)
			        	.collect(Collectors.joining(","));

		
		
        return authHelper.generateJwtAuthToken(user.getUsername(), 
				                                   Map.of("roles", roles));
	}
	
	@Override 
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {

		String reqMethod = request.getMethod();
		String reqUri = request.getRequestURI();
		boolean isLogin = HttpMethod.POST.matches(reqMethod) && reqUri.startsWith("/login");

		return !isLogin;
	}

}
