package com.cd.controller;

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

import com.cd.entity.Entity1;
import com.cd.service.impl.CollegeServiceImpl;


@RestController
@RequestMapping("api/v1/college")
public class CollegeController {

	@Autowired
	CollegeServiceImpl service;

	@PostMapping("/create")
	public String insert(@RequestBody Entity1 entity) {
		Optional<Entity1> op = service.insert(entity);
		if (op.isPresent()) {
			return "Create Successfully";
		} else {
			return "This Stud Already Have In Record";
		}

	}

	@GetMapping("getAllStud")
	public List<Entity1> getall() {
		return service.allstud();
	}

	@GetMapping("getStud/{studId}")
	public ResponseEntity<Entity1> getstud(@PathVariable("studId") int id) {
		Optional<Entity1> op = service.retriveone(id);
		if (op.isPresent()) {
			return new ResponseEntity<>(op.get(), (HttpStatus.OK));
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("stud/update")
	public String update(@RequestBody Entity1 entity) {
		Optional<Entity1> op = service.update(entity);
		if (op.isEmpty()) {
			return "This Stud Already Have In Record";
		} else {

			return "Update Successfully";
		}
	}

	@DeleteMapping("delete/stud/{studId}")
	public String delete(@PathVariable("studId") int id) {

		return service.delete(id);
	}

}
