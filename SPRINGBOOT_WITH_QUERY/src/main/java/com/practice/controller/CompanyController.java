package com.practice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.entity.Company;
import com.practice.service.impl.CompanyServiceImpl;

@RestController
@RequestMapping("api/v1/company")
public class CompanyController {
	
	@Autowired
	CompanyServiceImpl service;
	
	
	@GetMapping("/getCompany")
	public List<Company> view (){
		return  service.get();
		
	}
	

	@GetMapping("/getCompany/{id}")
	public List<Company> viewone (@PathVariable("id") int id){
		return  service.getone(id);
		
	}
	
	@DeleteMapping("/companyDelete/{id}")
	public String delete(@PathVariable("id") int id ) {
		 service.delete(id);
		 return "delete successfull";
	}
	
	@PutMapping("/companyUpdate/name={name}/ownername={names}/id={id}")
	public void update(@PathVariable("name")String name,@PathVariable("names")String names,@PathVariable("id") int id) {
		service.update(name,names,id);
		
	}
	
	
}
