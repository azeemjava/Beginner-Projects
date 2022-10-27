package in.tritonlabs.adharcard.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.tritonlabs.adharcard.entity.AdharDetail;
import in.tritonlabs.adharcard.repository.IAdharDeatilRepository;
import in.tritonlabs.adharcard.service.IAdharDetailServcie;

@Service
public class AdharDetailServiceImpl implements IAdharDetailServcie {

	@Autowired
	IAdharDeatilRepository adharDeatilRepo;

	public Optional<List<AdharDetail>> createAdharDetail(List<AdharDetail> adharDetail) {

		return Optional.of(adharDeatilRepo.saveAll(adharDetail));
	}

	public List<AdharDetail> readAll() {

		return adharDeatilRepo.findAll();

	}

	public Optional<AdharDetail> readOne(long id) {

		return adharDeatilRepo.getOne(id);

	}
	
	public Optional<List<AdharDetail>> UpdateAdharDetail(List<AdharDetail> adharDetail ){
		
		return Optional.of(adharDeatilRepo.saveAll(adharDetail));
	}
}