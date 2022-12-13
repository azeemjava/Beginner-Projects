package in.triton.all.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.triton.all.entity.Student;
import in.triton.all.repository.StudentRepository;

@Service
public class CustomizeUserDetailService  implements UserDetailsService {

	@Autowired
	StudentRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Student> findStudent=repository.findByEmail(username);
		
		Student student=findStudent.get();

		UserDetails user=User.withUsername(student.getEmail()).password(student.getPassword()).authorities(student.getRole()).build();
		return user;
	}

	
}
