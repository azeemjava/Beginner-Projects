package com.cd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cd.entity.Entitys;

@Repository
public interface ITaskRepository extends JpaRepository<Entitys, Integer> {}
