package com.one_to_one.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.one_to_one.entity.Profile;

@Repository
public interface IProfileRepository extends JpaRepository<Profile, Integer> {}
