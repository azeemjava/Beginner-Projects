package com.one_to_one.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.one_to_one.entity.Employee;
import com.one_to_one.entity.Profile;
import com.one_to_one.service.impl.EmployeeServiceImpl;
import com.one_to_one.service.impl.ProfileServiceImpl;

@RestController
@RequestMapping("api/v1/emp")
public class EmpController {

	@Autowired
	EmployeeServiceImpl employee;

	@Autowired
	ProfileServiceImpl profile;

	@GetMapping("getAllEmployee")
	public List<Employee> views() {
		return employee.view();
	}

	@GetMapping("getEmployee/{empid}")
	public ResponseEntity<Employee> retriveone1(@PathVariable("empid") int id) {
		Optional<Employee> op = employee.retriveone(id);
		if (op.isPresent()) {
			return new ResponseEntity<>(op.get(), (HttpStatus.OK));

		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}

	@PostMapping("createEmployee")
	public String inserts(@RequestBody Employee emp) {
		Optional<Employee> op = employee.insert(emp);
		if (op.isPresent()) {
			return "create successfully";
		} else {
			return "create faild";

		}
	}

	@PutMapping("updateEmployee")
	public String update1(@RequestBody Employee emp) {
		Optional<Employee> op = employee.update(emp);
		if (op.isPresent()) {
			return "update successfully";
		} else {
			return "update failed";
		}
	}

	@DeleteMapping("deleteEmployee/{empid}")
	public String delete(@PathVariable("empid") int id) {

		return employee.delete(id);
	}

	
	//////////////////////////////////////////////////////////////
	
	@GetMapping("getAllProfile")
	public List<Profile> view() {
		return profile.view();
	}

	@PostMapping("createProfile")
	public String insert(@RequestBody Profile pro) {
		Optional<Profile> op = profile.insert(pro);
		if (op.isPresent()) {
			return "create successfully";
		} else {
			return "create faild";

		}
	}


	@GetMapping("getProfile/{proid}")
	public ResponseEntity<Profile> retriveone(@PathVariable("proid") int id) {
		Optional<Profile> op = profile.retriveone(id);
		if (op.isPresent()) {
			return new ResponseEntity<>(op.get(), HttpStatus.OK);

		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}

	@DeleteMapping("deleteProfile/{proid}")
	public String delete1(@PathVariable("proid") int id) {

		return profile.delete(id);
	}


	@PutMapping("updateProfile")
	public String update(@RequestBody Profile pro) {
		Optional<Profile> op = profile.update(pro);
		if (op.isEmpty()) {
			return "update failed";

		} else {
			return "update successfully";

		}
	}

	
}
