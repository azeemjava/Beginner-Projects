package in.tritonlabs.adharcard.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "adhar")
public class Adhar {

	@OneToOne(mappedBy = "adhar",cascade = CascadeType.REMOVE)
	AdharDetail adhardetail;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "adhar_id")
	private long adharId;

	@Column(name = "name")
	private String name;

	@Column(name = "date_of_birth")
	private String dateOfBirth;

	@Column(name = "gender")
	private String gender;

	
	public long getAdharId() {
		return adharId;
	}

	public void setAdharId(int adharId) {
		this.adharId = adharId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
