package com.one_to_one.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "details")
public class Details {


	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id")
	private Employee emp;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int D_id;
	private int age;
	private long ph;
	private String gmail;
	private String address;
	private long pincode;


	public Details(int D_id, int age, long ph, String gmail, String address, long pincode, Employee emp) {
		super();
		this.D_id = D_id;
		this.age = age;
		this.ph = ph;
		this.gmail = gmail;
		this.address = address;
		this.pincode = pincode;
		this.emp = emp;
		

	}

	public Details() {
		super();
	}

	public int getD_id() {
		return D_id;
	}

	public void setD_id(int d_id) {
		D_id = d_id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getPh() {
		return ph;
	}

	public void setPh(long ph) {
		this.ph = ph;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	
}
