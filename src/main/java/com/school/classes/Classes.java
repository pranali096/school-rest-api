package com.school.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="classes_tb")
public class Classes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name="Classes_Name")
	private String classesName;

	public Classes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassName() {
		return classesName;
	}

	public void setClassName(String className) {
		this.classesName = className;
	}

	@Override
	public String toString() {
		return "Classes [id=" + id + ", className=" + classesName + "]";
	}
	
	
}
