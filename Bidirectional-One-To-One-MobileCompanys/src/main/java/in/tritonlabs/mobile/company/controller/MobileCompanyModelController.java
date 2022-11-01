package in.tritonlabs.mobile.company.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.tritonlabs.mobile.company.entity.MobileCompany;
import in.tritonlabs.mobile.company.entity.MobileCompanyModel;
import in.tritonlabs.mobile.company.service.impl.MobileCompanyModelServiceImpl;
import in.tritonlabs.mobile.company.service.impl.MobileCompanyServiceImpl;

@RestController
@RequestMapping("api/v1/mobile-company-model")
public class MobileCompanyModelController {

	@Autowired
	MobileCompanyModelServiceImpl mobileCompanyModelService;

	
}
