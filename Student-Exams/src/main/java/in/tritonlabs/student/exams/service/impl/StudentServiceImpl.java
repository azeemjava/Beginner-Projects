package in.tritonlabs.student.exams.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.tritonlabs.student.exams.entity.Student;
import in.tritonlabs.student.exams.repository.IStudentRepository;
import in.tritonlabs.student.exams.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	IStudentRepository studentRepo;

	// --------------------- getAll  ------------------------------------------------------

	public List<Student> readAll() {
		return studentRepo.findAll();
	}

	// --------------------- getOne ------------------------------------------------------

	public Optional<Student> readOne(long id) {
		return studentRepo.findById(id);
	}

	// --------------------- create ------------------------------------------------------

	public List<Student> create(List<Student> students) {

		return studentRepo.saveAll(students);

	}

	// --------------------- update ------------------------------------------------------

	public Student update(Student students, long id) {

		Student studentsGet = new Student();

		if (students.getStudentName().equals("")) {

			studentsGet.setId(id);

			Optional<Student> studentsFind = studentRepo.findById(id);

			Student student = studentsFind.get();

			studentsGet.setStudentName(student.getStudentName());

		} else {

			studentsGet.setId(id);

			studentsGet.setStudentName(students.getStudentName());

		}
		return studentRepo.save(studentsGet);

	}

	// --------------------- deleteOne -----------------------------------------------------

	public String deleteOne(long id) {
		studentRepo.deleteById(id);
		return "Deleted";
	}

	// --------------------- deletAll ------------------------------------------------------

	public String delete() {
		studentRepo.deleteAll();
		return "Deleted All";
	}
}
