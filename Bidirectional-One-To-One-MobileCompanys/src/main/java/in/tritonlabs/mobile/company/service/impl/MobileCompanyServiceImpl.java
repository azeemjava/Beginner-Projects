package in.tritonlabs.mobile.company.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.tritonlabs.mobile.company.entity.MobileCompany;
import in.tritonlabs.mobile.company.entity.MobileCompanyModel;
import in.tritonlabs.mobile.company.repository.IMobileCompanyRepositoy;
import in.tritonlabs.mobile.company.service.IMobileCompanyService;

@Service
public class MobileCompanyServiceImpl implements IMobileCompanyService {

	@Autowired
	IMobileCompanyRepositoy mobileCompanyRepo;

	public List<MobileCompany> getAll() {

		return mobileCompanyRepo.findAll();
	}

	public MobileCompany saveAll(MobileCompany mobileCompany) {

		MobileCompanyModel model = mobileCompany.getMobilecompanymodel();

		model.setMobilecompany(mobileCompany);

		mobileCompanyRepo.save(mobileCompany);
		
		mobileCompany.setModelRefId(model.getId());
		
		mobileCompanyRepo.save(mobileCompany);


		return mobileCompany;

	}

	public Optional<MobileCompany> getOne(long id) {

		return mobileCompanyRepo.findById(id);
	}

	public MobileCompany update(MobileCompany mobileCompany) {

		MobileCompanyModel model = mobileCompany.getMobilecompanymodel();

		model.setMobilecompany(mobileCompany);

		mobileCompanyRepo.save(mobileCompany);
		
		mobileCompany.setModelRefId(model.getId());
		
		mobileCompanyRepo.save(mobileCompany);
		return mobileCompany;
	}

	public String deleteOne(long id) {

		mobileCompanyRepo.deleteById(id);

		return null;
	}

}
