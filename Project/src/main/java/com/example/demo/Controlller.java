package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlller {
	
	@Autowired
	Repo re;
	
	@GetMapping("books")
    public List<Pojjo> getbooks(){
    	return re.findAll();
    }
	@PostMapping("books/add")
	public void addbook(@RequestBody Pojjo po) {
		re.save(po);
	}
	
}
