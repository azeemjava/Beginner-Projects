package in.tritonlabs.student.exams.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.tritonlabs.student.exams.entity.Exams;
import in.tritonlabs.student.exams.repository.IExamRepository;
import in.tritonlabs.student.exams.service.IExamService;

@Service
public class ExamsServiceImpl implements IExamService {

	@Autowired
	IExamRepository examRepo;

//--------------------- getAll ------------------------------------------------------	

	public List<Exams> readAll() {
		return examRepo.findAll();
	}

//--------------------- getOne ------------------------------------------------------	

	public Optional<Exams> readOne(long id) {
		return examRepo.findById(id);
	}

//--------------------- create ------------------------------------------------------	

	public List<Exams> create(List<Exams> exams) {

		return examRepo.saveAll(exams);

	}

//--------------------- update ------------------------------------------------------	

	public Exams update(Exams exams, long id) {

		Exams examsGet = new Exams();

		if (exams.getName().equals("")) {

			examsGet.setId(id);

			Optional<Exams> examsFind = examRepo.findById(id);

			Exams exam = examsFind.get();

			examsGet.setName(exam.getName());

		} else {

			examsGet.setId(id);

			examsGet.setName(exams.getName());

		}
		return examRepo.save(examsGet);

	}

//--------------------- deleteOne ------------------------------------------------------	

	public String deleteOne(long id) {
		examRepo.deleteById(id);
		return "Deleted";
	}

//--------------------- deletAll ------------------------------------------------------	

	public String delete() {
		examRepo.deleteAll();
		return "Deleted All";
	}
}
