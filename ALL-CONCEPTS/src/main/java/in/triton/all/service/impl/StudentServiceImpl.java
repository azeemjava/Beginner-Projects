package in.triton.all.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.aspectj.weaver.ast.Var;
import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.cfg.ContextAttributes.Impl;

import in.triton.all.api.response.ApiResponse;
import in.triton.all.entity.Course;
import in.triton.all.entity.CourseStudent;
import in.triton.all.entity.Department;
import in.triton.all.entity.GetData;
import in.triton.all.entity.Student;
import in.triton.all.exception.IncorrectException;
import in.triton.all.exception.ResourceAlreadyExists;
import in.triton.all.exception.ResourceNotFound;
import in.triton.all.filter.LoginFilter;
import in.triton.all.mapping.CourseRequestMapper;
import in.triton.all.mapping.CourseStudentRequestMapper;
import in.triton.all.mapping.StudentRequestMapper;
import in.triton.all.mapping.StudentResponseMapper;
import in.triton.all.repository.CourseStudentRepository;
import in.triton.all.repository.DepartmentRepository;
import in.triton.all.repository.StudentRepository;
import in.triton.all.request.CourseRequest;
import in.triton.all.request.StudentRequest;
import in.triton.all.request.StudentSetCourseRequest;
import in.triton.all.response.StudentResponse;
import in.triton.all.service.IStudentService;
import io.swagger.v3.oas.models.security.SecurityScheme.In;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private CourseStudentRepository courseStudentRepository;

	@Autowired
	StudentRequestMapper studentRequestMapper;

	@Autowired
	StudentResponseMapper studentResponseMapper;

	@Autowired
	CourseRequestMapper courseRequestMapper;

	@Autowired
	CourseStudentRequestMapper courseStudentRequestMapper;

	GetData data = new GetData();

	public ApiResponse saveAll(StudentRequest studentRequest) throws ResourceAlreadyExists, ResourceNotFound {

		Student studentFind = new Student();

		Optional<Student> optional = studentRepository.findById(studentFind.getStudentId());
		if (optional.isPresent()) {
			throw new ResourceAlreadyExists(" This Student Alreday Exists ");
		}
		Optional<Department> departmentGet = departmentRepository.findById(studentRequest.getDepartmentId());
		if (departmentGet.isEmpty()) {
			throw new ResourceNotFound(" This Department Not Found ");
		}
		String ph = studentRequest.getParent().getPhoneNumber();
		if (ph.length() > 10 || ph.length() < 10) {
			throw new IncorrectException(" Phone Number Must Be 10 Digits ");
		}

		Optional<Student> optionalEmail = studentRepository.findByEmail(studentFind.getEmail());

		if (optionalEmail.isPresent()) {
			throw new ResourceAlreadyExists(" This Email Alreday Exists ");
		}

		Department department = departmentGet.get();
		Student student = studentRequestMapper.modelToEntity(studentRequest, department);
		student = studentRepository.save(student);
		StudentResponse studentResponse = studentResponseMapper.entityToModel(student);
		ApiResponse apiResponse = new ApiResponse(studentResponse, null, "SUCCESSFULL", 201);
		return apiResponse;
	}

	@Override
	public ApiResponse getAll() {

		Optional<Student> studentGet = studentRepository.findByEmail(data.getEmail());
		Student student = studentGet.get();

		ApiResponse apiResponse = null;

		if (student.getEmail() .equals( data.getEmail())) {

			apiResponse = new ApiResponse(student, null, "SUCCESSFULL", 200);

		}

	
//		List<Student> studentGet = studentRepository.findAll();
//		List<StudentResponse> studentResponse = studentResponseMapper.entityToModel(studentGet);
//		ApiResponse apiResponse = new ApiResponse(studentResponse, null, "SUCCESSFULL", 200);
		return apiResponse;
	}

	@Override
	public ApiResponse getOne(int id) {
		Optional<Student> studentGet = studentRepository.findById(id);
		if (studentGet.isEmpty()) {
			throw new ResourceNotFound(id + " This Resource Not Found");
		}
		StudentResponse studentResponse = studentResponseMapper.entityToModel(studentGet);
		ApiResponse apiResponse = new ApiResponse(studentResponse, null, "SUCCESSFULL", 200);
		return apiResponse;
	}

	@Override
	public ApiResponse update(@Valid StudentRequest studentRequest, int id) {
		Optional<Student> studentGet = studentRepository.findById(id);
		if (studentGet.isEmpty()) {
			throw new ResourceNotFound(id + " This Resource Not Found");
		}

		Optional<Department> departmentGet = departmentRepository.findById(studentRequest.getDepartmentId());
		if (departmentGet.isEmpty()) {
			throw new ResourceNotFound(" This Department Not Found ");
		}
		Department department = departmentGet.get();
		Student student = studentRequestMapper.modelToEntitys(studentRequest, department, id);

		student = studentRepository.save(student);
		StudentResponse studentResponse = studentResponseMapper.entityToModel(student);
		ApiResponse apiResponse = new ApiResponse(studentResponse, null, "SUCCESSFULL", 200);
		return apiResponse;
	}

	@Override
	public ApiResponse delete(int id) {
		Optional<Student> studentGet = studentRepository.findById(id);
		if (studentGet.isEmpty()) {
			throw new ResourceNotFound(id + " This Resource Not Found");
		}
		ApiResponse apiResponse = new ApiResponse(id + " Deleted", null, "SUCCESSFULL", 200);
		return apiResponse;
	}

	@Override
	public ApiResponse deleteAll() {
		studentRepository.deleteAll();
		ApiResponse apiResponse = new ApiResponse(" Deleted All", null, "SUCCESSFULL", 200);
		return apiResponse;
	}

	@Override
	public ApiResponse saveAll(@Valid List<CourseStudent> courseStudent, int id) {

		courseStudent.stream().forEach(c -> c.setStudentId(id));

		Optional<Student> studentGet = studentRepository.findById(id);
		if (studentGet.isEmpty()) {
			throw new ResourceNotFound(id + " This Student Not Found");
		}

		courseStudent = courseStudentRepository.saveAll(courseStudent);

		ApiResponse apiResponse = new ApiResponse(courseStudent, null, "SUCCESSFULL", 200);
		return apiResponse;

	}

	public ApiResponse getAllCourse() {

		List<CourseStudent> courseStudent = courseStudentRepository.findAll();
		ApiResponse apiResponse = new ApiResponse(courseStudent, null, "SUCCESSFULL", 200);
		return apiResponse;

	}

	public void getData(String email, String password) {
		data.setEmail(email);
		data.setPassword(password);
	}

}
