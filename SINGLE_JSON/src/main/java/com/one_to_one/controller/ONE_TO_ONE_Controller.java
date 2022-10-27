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

import com.one_to_one.entity.Details;
import com.one_to_one.repository.DetailsRepository;
import com.one_to_one.service.impl.DetailServiceImpl;

@RestController
@RequestMapping("api/v1/one")
public class ONE_TO_ONE_Controller {

	@Autowired
	DetailServiceImpl dservice;

	@Autowired
	DetailsRepository repo;

	@DeleteMapping("deleteEmployees/{proid}")
	public String dlete1(@PathVariable("proid") int id) {

		return dservice.dlete(id);
	}

	@PostMapping("/saveEmployees")
	public ResponseEntity<String> saveEmployees(@RequestBody List<Details> empData) {
		repo.saveAll(empData);
		return ResponseEntity.ok("Data saved");
	}

	@GetMapping("/getAllEmployees")
	public List<Details> view() {
		return dservice.view();
	}

	@GetMapping("getEmployee/{empid}")
	public ResponseEntity<Details> retriveone1(@PathVariable("empid") int id) {
		Optional<Details> op = dservice.retriveone(id);
		if (op.isPresent()) {
			return new ResponseEntity<>(op.get(), (HttpStatus.OK));

		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}

	}
}