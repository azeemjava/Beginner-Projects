package com.practice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.entity.Company;
import com.practice.iservice.ICompanysService;
import com.practice.repository.ICompanyRepository;

@Service
public class CompanyServiceImpl implements ICompanysService {

	@Autowired
	ICompanyRepository repo;

	public List<Company> getone(int id) {
		return repo.findone(id);
	}

	public List<Company> get() {

		return repo.find();

	}

	public String delete(int id) {
		
		return repo.deleteone(id);

	}

	
	public void update(String name,String names,int id) {
		repo.update(name,names,id);
	}
}
