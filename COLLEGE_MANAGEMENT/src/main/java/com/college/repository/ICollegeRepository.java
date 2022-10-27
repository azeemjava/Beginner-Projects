package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.entity.Entity1;

@Repository
public interface ICollegeRepository extends JpaRepository<Entity1, Integer> {

}
