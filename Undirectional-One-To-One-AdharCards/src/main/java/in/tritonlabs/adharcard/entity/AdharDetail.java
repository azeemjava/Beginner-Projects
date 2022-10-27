package in.tritonlabs.adharcard.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "adhardetail")
public class AdharDetail {

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "adhar_id_fkey", referencedColumnName = "adhar_id")
	Adhar adhar;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "detail_id")
	private long detailId;
	
	@Column(name = "son_of")
	private String sonOf;

	@Column(name = "house_no")
	private int houseNo;

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;

	@Column(name = "district")
	private String district;

	@Column(name = "phone_no")
	private String phoneNo;

	
	public Adhar getAdhar() {
		return adhar;
	}

	public void setAdhar(Adhar adhar) {
		this.adhar = adhar;
	}

	public long getDetailId() {
		return detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}

	public String getSonOf() {
		return sonOf;
	}

	public void setSonOf(String sonOf) {
		this.sonOf = sonOf;
	}

	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}
