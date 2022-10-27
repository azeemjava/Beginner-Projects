package com.one_to_one.IService;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.one_to_one.entity.Details;
import com.one_to_one.entity.Employee;

public interface IDetailService  {
	
	//public Optional<Details> insert(Details de);
	public List<Details> view();
	public Optional<Details> retriveone(int id);
	public String dlete(int id);
	public Optional<Details> update(Details de);
	

}
