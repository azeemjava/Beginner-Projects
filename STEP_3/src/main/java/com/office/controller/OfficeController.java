package com.office.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;

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

import com.office.entity.Entity1;
import com.office.iservice.IOfficeService;

@RestController
@RequestMapping("api/v1/office")
public class OfficeController {

	@Autowired
	public IOfficeService service;

	@GetMapping("/getAllEmployee")
	public List<Entity1> allemp() {
		return service.alldata();
	}

	@DeleteMapping("delete/employee/{employeeId}")
	public String deleteemp(@PathVariable("employeeId") int id) {
		return service.deletedata(id);
	}

	@PostMapping("/create")
	public String insertemp(@RequestBody Entity1 entity) {
		Optional<Entity1> op = service.insertdata(entity);
		if (op.isPresent()) {
			return "Create Successfully";
		} else {
			return "This Employee Already In Record";
		}
	}

	@GetMapping("getemployee/{employeeId}")
	public ResponseEntity<Entity1> retriveone(@PathVariable("employeeId") int id) {
		Optional<Entity1> op = service.onedata(id);
		if (op.isPresent()) {

			return new ResponseEntity<>(op.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("employee/upadte")
	public String updateemp(@RequestBody Entity1 entity) {

		Optional<Entity1> op = service.updatedata(entity);
		if (op.isEmpty()) {

			return "This employee already in record";
		} else {
			return "Update Successfully";
		}

	}

}
