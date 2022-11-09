package in.tritonlabs.student.exams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.tritonlabs.student.exams.entity.Exams;

@Repository
public interface IExamRepository extends JpaRepository<Exams, Long> {

	
	
}
