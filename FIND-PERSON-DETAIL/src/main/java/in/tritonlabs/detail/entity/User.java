package in.tritonlabs.detail.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;

	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	@JsonIgnoreProperties("user")
	private List<Adhar> adhar;

	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	@JsonIgnoreProperties("user")
	private List<Vote> vote;

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

	public List<Adhar> getAdhar() {
		return adhar;
	}

	public void setAdhar(List<Adhar> adhar) {
		this.adhar = adhar;
	}

	public List<Vote> getVote() {
		return vote;
	}

	public void setVote(List<Vote> vote) {
		this.vote = vote;
	}

}
