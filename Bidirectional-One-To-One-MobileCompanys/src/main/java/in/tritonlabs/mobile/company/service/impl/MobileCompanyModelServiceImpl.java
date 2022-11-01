package in.tritonlabs.mobile.company.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import in.tritonlabs.mobile.company.entity.MobileCompany;
import in.tritonlabs.mobile.company.entity.MobileCompanyModel;
import in.tritonlabs.mobile.company.repository.IMobileCompanyModelRepository;
import in.tritonlabs.mobile.company.repository.IMobileCompanyRepositoy;
import in.tritonlabs.mobile.company.service.IMobileCompanyModelService;

@Service
public class MobileCompanyModelServiceImpl implements IMobileCompanyModelService {

	@Autowired
	IMobileCompanyModelRepository mobileCompanyModelRepo;

	
}
