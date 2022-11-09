package in.tritonlabs.student.exams.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import in.tritonlabs.student.exams.entity.ExaminationStudent;

@Repository
public interface IExaminationStudentRepository extends JpaRepository<ExaminationStudent, Long> {

	@Query(value = "select *from examination_student",nativeQuery = true)
	List<ExaminationStudent> findAllMyTable();

}
