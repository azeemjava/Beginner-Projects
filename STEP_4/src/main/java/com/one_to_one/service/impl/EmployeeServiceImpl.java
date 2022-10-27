package com.one_to_one.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one_to_one.entity.Employee;
import com.one_to_one.repository.IEmployeeRepository;
import com.one_to_one.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	IEmployeeRepository repo;

	public List<Employee> view() {

		return repo.findAll();

	}

	public Optional<Employee> insert(Employee emp) {
		if (repo.existsById(emp.getEmpid())) {
			return Optional.empty();
		} else {
			return Optional.of(repo.save(emp));
		}

	}

	public Optional<Employee> retriveone(int id) {

		return repo.findById(id);
		}
		
		
	

	public String delete(int id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return "delete successfully";
		}
		else {
			return "delete faild";
		}
	}

	public Optional<Employee> update(Employee emp){
		if(repo.existsById(emp.getEmpid())) {
			return Optional.of(repo.save(emp));
		}
		else {
			return Optional.empty();
		}
	}

}
