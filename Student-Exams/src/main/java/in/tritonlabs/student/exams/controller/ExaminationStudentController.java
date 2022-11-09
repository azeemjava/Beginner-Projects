package in.tritonlabs.student.exams.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.tritonlabs.student.exams.entity.ExaminationStudent;
import in.tritonlabs.student.exams.service.impl.ExaminationStudentServiceImpl;
import in.tritonlabs.student.exams.service.impl.ExamsServiceImpl;

@RestController
@RequestMapping("api/v1/examinationStudent")
public class ExaminationStudentController {

	@Autowired
	ExaminationStudentServiceImpl Service;


	@Autowired
	ExamsServiceImpl examService;

	@GetMapping("/")
	public List<ExaminationStudent> readAll() {
		return Service.readAll();
	}

	@GetMapping("/{id}")
	public Optional<ExaminationStudent> readOne(@PathVariable("id") long id) {

		return Service.readOne(id);
	}

	@PostMapping("/")
	public ResponseEntity<ExaminationStudent> create(@RequestBody List<ExaminationStudent> examinationStudents) {

		Service.create(examinationStudents);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ExaminationStudent update(@RequestBody ExaminationStudent examinationStudents, @PathVariable("id") long id) {
		return Service.update(examinationStudents, id);
	}

	@DeleteMapping("/{id}")
	public String deleteOne(@PathVariable("id") long id) {
		return Service.deleteOne(id);
	}

	@DeleteMapping("/")
	public String delete() {
		return Service.delete();
	}

}
