package in.tritonlabs.student.exams.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.tritonlabs.student.exams.entity.ExaminationStudent;
import in.tritonlabs.student.exams.repository.IExaminationStudentRepository;
import in.tritonlabs.student.exams.service.IExaminatiomStudentService;

@Service
public class ExaminationStudentServiceImpl implements IExaminatiomStudentService {

	@Autowired
	IExaminationStudentRepository examRepo;

	
	// --------------------- getAll  ------------------------------------------------------

	public List<ExaminationStudent> readAll() {
		return examRepo.findAll();
	}

	// --------------------- getOne  ------------------------------------------------------

	public Optional<ExaminationStudent> readOne(long id) {
		return examRepo.findById(id);
	}

	// --------------------- create ------------------------------------------------------

	public List<ExaminationStudent> create(List<ExaminationStudent> examinationStudents) {

		return examRepo.saveAll(examinationStudents);

	}

	// --------------------- update ----------------------------------------------------

	public ExaminationStudent update(ExaminationStudent examinationStudent, long id) {
		
		ExaminationStudent examinationStudentObj = new ExaminationStudent();
		examinationStudentObj.setId(id);
		examinationStudentObj.setExamId(examinationStudent.getExamId());
		examinationStudentObj.setStudentId(examinationStudent.getStudentId());
		return examRepo.save(examinationStudentObj);
	}

	// --------------------- deleteOne -----------------------------------------------------

	public String deleteOne(long id) {
		examRepo.deleteById(id);
		return "Deleted";
	}

	// --------------------- deletAll ------------------------------------------------------

	public String delete() {
		examRepo.deleteAll();
		return "Deleted All";
	}

}
