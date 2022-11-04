package in.tritonlabs.detail.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.tritonlabs.detail.service.impl.AdharServiceImpl;

@RestController
@RequestMapping("api/v1/adhar")
public class AdharController {

	@Autowired
	AdharServiceImpl adharService;

//
//
//	@GetMapping("/{id}")
//	public Adhar readOne(@PathVariable("id") long id) {
//		Optional<Adhar> op = adharService.readOne(id);
//		return op.get();
//
//	}
//
////	@PostMapping("/{id}")
////	public String create(@RequestBody AdharRequest adharRequest, @PathVariable long id) {
////		adharService.create(adharRequest, id);
////		return "Saved";
////	}
////
////	@PutMapping("/{id}")
////	public String update(@RequestBody AdharRequest adharRequest, @PathVariable long id) {
////		adharService.update(adharRequest, id);
////		return "Updated";
////	}
////	
//	@DeleteMapping("/{id}")
//	public String delete(@PathVariable("id") long id) {
//		adharService.delete(id);
//		return "Deleted";
//		
//	}
}
