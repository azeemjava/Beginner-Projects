package com.one_to_one.entity;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "profile")
public class Profile {

	@Id
	private int roll;
	private int ph;
	private String gmail;
	private String technology;
	private String status;

	@OneToOne
	private Employee emp;
	
	

	public Profile() {
		super();
	}

	public Profile(int roll, int ph, String gmail, String technology, String status, Employee emp) {
		super();
		this.roll = roll;
		this.ph = ph;
		this.gmail = gmail;
		this.technology = technology;
		this.status = status;
		this.emp = emp;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public int getPh() {
		return ph;
	}

	public void setPh(int ph) {
		this.ph = ph;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

}
