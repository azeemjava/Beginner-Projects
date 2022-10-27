package com.office.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.office.entity.Entity1;
import com.office.iservice.IOfficeService;
import com.office.repository.IOfficeRepository;

@Service
public class OfficeServiceImpl implements IOfficeService {

	@Autowired
	IOfficeRepository repo;

	// READ ALL
	public List<Entity1> alldata() {

		return repo.findAll();
	}

	// CREATE
	public Optional<Entity1> insertdata(Entity1 office) {

		if (repo.existsById(office.getId())) {

			return Optional.empty();
		} else {
			return Optional.of(repo.save(office));
		}
	}

	// DELETE
	public String deletedata(int empid) {

		if (repo.existsById(empid)) {

			repo.deleteById(empid);
			return empid + "    Delete successfully";

		} else {

			return "This employee not in record";
		}
	}

	// Retrieve one
	public Optional<Entity1> onedata(int id) {

		return repo.findById(id);

	}

	// Update
	public Optional<Entity1> updatedata(Entity1 entity){

		if(repo.existsById(entity.getId())) {
			
			return Optional.of(repo.save(entity));
		}
		
		return Optional.empty();
	}
	
	
	
	
	
	
	
	
	
}