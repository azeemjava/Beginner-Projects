package com.one_to_one.service;

import java.util.List;
import java.util.Optional;

import com.one_to_one.entity.Employee;

public interface IEmployeeService  {
	
	public List<Employee> view ();

	public Optional<Employee> insert(Employee emp);
	
	public Optional<Employee> retriveone(int id);
	
	public String delete(int id);
	
	public Optional<Employee> update(Employee emp);

	
}
