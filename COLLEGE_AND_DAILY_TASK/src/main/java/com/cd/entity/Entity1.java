package com.cd.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "college")
public class Entity1 {

	@Id
	private int id;
	private String name;
	private int age;
	private String dept;
	private int ph;
	private String city;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getPh() {
		return ph;
	}

	public void setPh(int ph) {
		this.ph = ph;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	public Entity1() {
		super();
	}

	public Entity1(int id, String name, int age, String dept, int ph, String city) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.dept = dept;
		this.ph = ph;
		this.city = city;
	}
}
