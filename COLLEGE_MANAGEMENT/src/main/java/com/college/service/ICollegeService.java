package com.college.service;

import java.util.List;
import java.util.Optional;

import com.college.entity.Entity1;

public interface ICollegeService {

	public List<Entity1> allstud();
	public Optional<Entity1> retriveone(int id);
	public String delete(int id);
	public Optional<Entity1> update(Entity1 entity);
	public Optional<Entity1> insert(Entity1 entity);
}
