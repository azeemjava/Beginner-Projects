package com.cd.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cd.entity.Entitys;
import com.cd.iservice.ITaskService;
import com.cd.repository.ITaskRepository;

@Service
public class TaskServiceImpl implements ITaskService {

	@Autowired
	ITaskRepository repo;

	public List<Entitys> getall() {

		return repo.findAll();

	}

	public Optional<Entitys> retriveone(int id) {

		return repo.findById(id);
	}

	public String delete(int id) {

		if (repo.existsById(id)) {

			repo.deleteById(id);

			return id + "  Delete Successfully ";

		} else {

			return id + " This id not in record ";
		}
	}

	public Optional<Entitys> insert(Entitys entity) {
		if (repo.existsById(entity.getId())) {

			return Optional.empty();

		} else {

			return Optional.of(repo.save(entity));
		}
	}

	public Optional<Entitys> update(Entitys entity) {

		if (repo.existsById(entity.getId())) {

			return Optional.of(repo.save(entity));
		}

		else {
			return Optional.empty();

		}
	}

}
