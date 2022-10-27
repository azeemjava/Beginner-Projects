package com.cd.iservice;

import java.util.List;
import java.util.Optional;

import com.cd.entity.Entitys;

public interface ITaskService {
	
	public List<Entitys> getall();
	public Optional<Entitys> retriveone(int id);
	public String delete(int id) ;
	public Optional<Entitys> insert(Entitys entity);
	public Optional<Entitys> update(Entitys entity);
	
}
