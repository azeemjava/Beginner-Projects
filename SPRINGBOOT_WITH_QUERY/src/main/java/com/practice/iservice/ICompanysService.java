package com.practice.iservice;

import java.util.List;
import java.util.Optional;

import com.practice.entity.Company;

public interface ICompanysService  {
	
	//public Optional<Company> create(Company com);
	//public Optional<Company> update(Company com);
   // public String delete(int id);
	public List<Company> get();
	public List<Company> getone(int id);
	
	

}
