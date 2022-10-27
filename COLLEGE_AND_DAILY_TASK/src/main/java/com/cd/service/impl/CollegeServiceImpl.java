package com.cd.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cd.entity.Entity1;
import com.cd.iservice.ICollegeService;
import com.cd.repository.ICollegeRepository;


@Service
public class CollegeServiceImpl implements ICollegeService {

	@Autowired
	ICollegeRepository repo;

	public List<Entity1> allstud() {
		return repo.findAll();
	}

	public Optional<Entity1> retriveone(int id) {
		return repo.findById(id);
	}

	public String delete(int id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			return id + " Delete Successfully ";
		} else {
			return "This Employee Not in Record ";
		}
	}

	public Optional<Entity1> update(Entity1 entity) {
		if (repo.existsById(entity.getId())) {

			return Optional.of(repo.save(entity));

		} else {

			return Optional.empty();
		}
	}

	public Optional<Entity1> insert(Entity1 entity) {
		if (repo.existsById(entity.getId())) {
			return Optional.empty();
		} else {
			return Optional.of(repo.save(entity));
		}

	}

}
