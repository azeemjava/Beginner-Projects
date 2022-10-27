package in.tritonlabs.adharcard.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.tritonlabs.adharcard.entity.AdharDetail;
import in.tritonlabs.adharcard.service.impl.AdharDetailServiceImpl;
import in.tritonlabs.adharcard.service.impl.AdharServiceImpl;

@RestController
@RequestMapping("api/v1/adharDetail")
public class AdharDetailController {

	@Autowired
	AdharDetailServiceImpl adharDetailServiceImpl;

	@Autowired
	AdharServiceImpl adharServiceImpl;

	@GetMapping("getAllAdharDetail")
	public List<AdharDetail> getAllAdharDetails() {
		return adharDetailServiceImpl.readAll();
	}

	@GetMapping("getOneAdharDetail/{id}")
	public Optional<AdharDetail> getOneAdharDetails(@PathVariable("id") long id) {
		return adharDetailServiceImpl.readOne(id);
	}

	@PostMapping("createAdharDetail")
	public ResponseEntity<String> createAdharDetail(@RequestBody List<AdharDetail> adharDetail) {
		Optional<List<AdharDetail>> op = adharDetailServiceImpl.createAdharDetail(adharDetail);

		return ResponseEntity.ok("Data Saved");
	}

	@DeleteMapping("deleteOneAdharDetail/{id}")
	public String deleteOneAdharDetail(@PathVariable("id") long id) {
		adharServiceImpl.deleteOneAdhar(id);
		return "Data Deleted";
	}

	@DeleteMapping("deleteAdharDetail")
	public String deleteAllAdharDetail() {
		adharServiceImpl.deleteAllAdhar();
		return "All Data Deleted";
	}

	@PutMapping("updateAdharDetail")
	public ResponseEntity<String> updateAdharDetail(@RequestBody List<AdharDetail> adharDetail) {
		Optional<List<AdharDetail>> op = adharDetailServiceImpl.UpdateAdharDetail(adharDetail);
		return ResponseEntity.ok("Data updated");
	}

}
