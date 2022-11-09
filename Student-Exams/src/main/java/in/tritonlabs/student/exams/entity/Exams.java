package in.tritonlabs.student.exams.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "exams")
public class Exams {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private long id;
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="examination_student" ,joinColumns = { 
    @JoinColumn(name="exam_id")},inverseJoinColumns = {
    @JoinColumn(name="student_id")})
	private Set<Student> student =new HashSet<Student>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
