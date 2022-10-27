package com.office.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="office")
public class Entity1 {
	
    @Id
    private int id;
	private String name;
	private int age ;
    private String address ;
    private String technology;
    
    
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
   
	
	
	public Entity1(int id, String name, int age, String address, String technology) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.technology = technology;
	}

    public Entity1() {
		super();
	}
}
