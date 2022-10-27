package com.one_to_one.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.one_to_one.IService.IDetailService;
import com.one_to_one.entity.Details;
import com.one_to_one.entity.Employee;
import com.one_to_one.repository.DetailsRepository;
import com.one_to_one.repository.EmployeeRepository;

@Service
public class DetailServiceImpl implements IDetailService {

	@Autowired
	DetailsRepository repo;

	@Autowired
	EmployeeRepository repo1;
	
	
	public List<Details> view(){
		
		return repo.findAll();
	}
	
	
	public Optional<Details> retriveone(int id){
		return repo.findById(id);
		}

	public String dlete(int id) {		
		
		    if(repo.existsById(id)) {
				repo.deleteById(id);
				return "delete successfully";
			 }
			else {
				return "delete faild";
			}
		}
	
	public Optional<Details> update(Details de){
		
		if(repo.existsById(de.getD_id())) {
				return Optional.of(repo.save(de));
			}
			else {
				return Optional.empty();
			}

		}
	}
	
