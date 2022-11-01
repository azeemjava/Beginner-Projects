package in.tritonlabs.mobile.company.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "mobile_company")
public class MobileCompany {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "company")
	private String company;

	@Column(name = "company_owner")
	private String companyOwner;
	
	@Column(name = "Model_ref_id")
	private long modelRefId;


	public long getModelRefId() {
		return modelRefId;
	}

	public void setModelRefId(long modelRefId) {
		this.modelRefId = modelRefId;
	}

	@OneToOne(mappedBy = "mobilecompany",cascade = CascadeType.ALL)
	MobileCompanyModel mobilecompanymodel;
	

	public MobileCompanyModel getMobilecompanymodel() {
		return mobilecompanymodel;
	}

	public void setMobilecompanymodel(MobileCompanyModel mobilecompanymodel) {
		this.mobilecompanymodel = mobilecompanymodel;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompanyOwner() {
		return companyOwner;
	}

	public void setCompanyOwner(String companyOwner) {
		this.companyOwner = companyOwner;
	}

	

}
