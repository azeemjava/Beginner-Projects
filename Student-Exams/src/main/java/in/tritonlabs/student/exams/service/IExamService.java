package in.tritonlabs.student.exams.service;

import java.util.List;
import java.util.Optional;
import in.tritonlabs.student.exams.entity.Exams;

public interface IExamService {

	public List<Exams> readAll();

	public Optional<Exams> readOne(long id);

	public List<Exams> create(List<Exams> exams);

	public Exams update(Exams exams, long id);

	public String deleteOne(long id);

	public String delete();

}