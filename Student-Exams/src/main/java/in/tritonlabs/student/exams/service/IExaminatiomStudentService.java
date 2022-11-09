package in.tritonlabs.student.exams.service;

import java.util.List;
import java.util.Optional;
import in.tritonlabs.student.exams.entity.ExaminationStudent;

public interface IExaminatiomStudentService {

	public List<ExaminationStudent> readAll();

	public Optional<ExaminationStudent> readOne(long id);

	public List<ExaminationStudent> create(List<ExaminationStudent> examinationStudents);

	public ExaminationStudent update(ExaminationStudent examinationStudent, long id);

	public String deleteOne(long id);

	public String delete();

}
