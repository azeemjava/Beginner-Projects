package com.cd.entity;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dailytask")
public class Entitys {

    
	@Id
	private int id;
	private String name;
	private String task;
	private String taskstatus;
	private String currentdate;
	
	
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


	public String getTask() {
		return task;
	}


	public void setTask(String task) {
		this.task = task;
	}


	public String getTaskstatus() {
		return taskstatus;
	}


	public void setTaskstatus(String taskstatus) {
		this.taskstatus = taskstatus;
	}


	public String getCurrentdate() {
		return currentdate;
	}


	public void setCurrentdate(String currentdate) {
		this.currentdate = currentdate;
	}



	
	public Entitys(int id, String name, String task, String taskstatus, String currentdate) {
		super();
		this.id = id;
		this.name = name;
		this.task = task;
		this.taskstatus = taskstatus;
		this.currentdate = currentdate;
	}

	
	public Entitys() {
		super();
	}
}