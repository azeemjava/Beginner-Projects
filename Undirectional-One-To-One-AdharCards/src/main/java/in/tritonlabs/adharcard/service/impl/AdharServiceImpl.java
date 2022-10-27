package in.tritonlabs.adharcard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.tritonlabs.adharcard.repository.IAdharRepository;
import in.tritonlabs.adharcard.service.IAdharService;

@Service
public class AdharServiceImpl implements IAdharService {

	@Autowired
	IAdharRepository adharRepo;

	public String deleteOneAdhar(long id) {
		adharRepo.deleteById(id);
		return null;
	}
	
	public String deleteAllAdhar() {
		adharRepo.deleteAll();
		return null;
	}

}
