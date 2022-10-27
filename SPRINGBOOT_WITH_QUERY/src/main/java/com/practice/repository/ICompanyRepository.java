package com.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.practice.entity.Company;

public interface ICompanyRepository extends JpaRepository<Company, Integer> {
	

    @Query(value = " SELECT * FROM company  ", nativeQuery = true)
    List<Company> find();
	
	


    @Query(value = " SELECT * FROM company where comid=:id ", nativeQuery = true)
    List<Company> findone(int id);
	

    @Query(value = " DELETE FROM company where comid=:id ", nativeQuery = true)
    String deleteone(int id);
	
    
    @Query(value="UPDATE company set comname=:name , ownername=:names where comid=:id",nativeQuery = true)
    void update(String name,String names,int id);
}
