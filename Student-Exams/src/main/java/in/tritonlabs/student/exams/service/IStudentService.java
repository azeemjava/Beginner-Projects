package in.tritonlabs.student.exams.service;

import java.util.List;
import java.util.Optional;
import in.tritonlabs.student.exams.entity.Student;

public interface IStudentService {

	public List<Student> readAll();
	
	public Optional<Student> readOne(long id);
		
	public List<Student> create(List<Student> students);

	public Student update(Student students, long id);

	public String deleteOne(long id);
	
	public String delete();
	
}
