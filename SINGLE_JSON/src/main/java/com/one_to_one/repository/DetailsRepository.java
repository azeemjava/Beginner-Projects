package com.one_to_one.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.one_to_one.entity.Details;

@Repository
public interface DetailsRepository extends JpaRepository<Details, Integer> {


	
	
	

}
