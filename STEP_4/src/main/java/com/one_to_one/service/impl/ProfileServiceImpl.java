package com.one_to_one.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one_to_one.entity.Profile;
import com.one_to_one.repository.IProfileRepository;
import com.one_to_one.service.IProfileService;

@Service
public class ProfileServiceImpl implements IProfileService {

	@Autowired
	IProfileRepository repo;

	public Optional<Profile> insert(Profile pro) {
		if (repo.existsById(pro.getRoll())) {
			return Optional.empty();
		} else {
			return Optional.of(repo.save(pro));
		}
	}

	public List<Profile> view() {
		return repo.findAll();
	}

	public Optional<Profile> retriveone(int id){
	
		return repo.findById(id);
	}
	

	public String delete(int id) {
		if(repo.existsById(id)) {
		   repo.deleteById(id);
		   return "delete successfuly";
		}
		else {
			return "delete failed";
		}
	}

	public Optional<Profile> update(Profile pro){
		if(repo.existsById(pro.getRoll())) {
			return Optional.of(repo.save(pro));
		}
		else {
			return Optional.empty();
		}
		
	}
}