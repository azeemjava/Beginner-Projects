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

import com.cd.entity.Entitys;
import com.cd.service.impl.TaskServiceImpl;

@RestController
@RequestMapping("api/v1/task")
public class TaskController {

	@Autowired
	TaskServiceImpl service;
	
	@GetMapping("/getAll")
	public List<Entitys> getall(){
		return service.getall();
	}
	
	@GetMapping("/getOne/{empId}")
	public ResponseEntity<Entitys> getone(@PathVariable("empId")  int id){
		Optional<Entitys> op =service.retriveone(id);
		if(op.isPresent()) {
			
			return new ResponseEntity<> (op.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
		}
		
		@DeleteMapping("/delete/{empId}")
        public String delete(@PathVariable ("empId") int id) {
			
			return service.delete(id);
		}
		
		@PostMapping("/create")
		public String insert(@RequestBody Entitys entity){
			Optional<Entitys>  op = service.insert(entity);
			
			if(op.isPresent()) {
				return entity.getId() + " Create Successfully";
			}else {

				return entity.getId() + " 	This Id Alresdy In Record ";
			}
			}
			
		@PutMapping("/update")
		public String update(@RequestBody Entitys entity) {
			Optional<Entitys> op=service.update(entity);
			if(op.isEmpty()) {

				return entity.getId() + "  This Id Not Record ";
				
			}else {
				return entity.getId() + "  This Id UpdateSuccessfully ";
				
			}
		}
			
			
		}

