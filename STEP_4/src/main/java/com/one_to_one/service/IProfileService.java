package com.one_to_one.service;

import java.util.List;
import java.util.Optional;

import com.one_to_one.entity.Profile;

public interface IProfileService {

	public Optional<Profile> insert(Profile pro);
	
	public List<Profile> view ();
	
	public Optional<Profile> retriveone(int id);
	
	public String delete(int id);
	
	public Optional<Profile> update(Profile pro);
}
