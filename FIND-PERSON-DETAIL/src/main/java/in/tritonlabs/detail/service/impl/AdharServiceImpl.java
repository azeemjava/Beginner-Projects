package in.tritonlabs.detail.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.tritonlabs.detail.repository.IAdharRepository;
import in.tritonlabs.detail.repository.IUserRepository;

import in.tritonlabs.detail.service.IAdharService;

@Service
public class AdharServiceImpl implements IAdharService {

	@Autowired
	IAdharRepository adharRepo;
	@Autowired
	IUserRepository userRepo;

//	public List<Adhar> ReadAll() {
//		return adharRepo.findAll();
//	}
//
//	public Optional<Adhar> readOne(long id) {
//
//		Optional<User> userop = userRepo.findById(id);
//		User user = userop.get();
//		List<Adhar> adhar = user.getAdhar();
//		Adhar adharGet = adhar.get(0);
//		long adharId = adharGet.getId();
//
//		return adharRepo.findById(adharId);
//	}
//
//
//
//	public String delete(long id) {
//
//		Optional<User> userop = userRepo.findById(id);
//		User user = userop.get();
//		List<Adhar> adhar = user.getAdhar();
//		Adhar adharGet = adhar.get(0);
//		long adharId = adharGet.getId();
//
//		adharRepo.deleteById(adharId);
//		return null;
//
//	}

}
