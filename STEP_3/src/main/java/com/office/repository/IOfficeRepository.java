package com.office.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.office.entity.Entity1;

@Repository
public interface IOfficeRepository extends JpaRepository<Entity1, Integer>{}
