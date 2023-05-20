package com.school.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.school.divisions.Divisions;

@Entity
@Table(name="classes_tb")
public class Classes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name="Classes_Name")
	private String classesName;
	
	 @OneToOne
	    @JoinColumn(name = " Division_id")
	    private Divisions division;
	 
	 



	public Classes(Long id, String classesName, Divisions division) {
		super();
		this.id = id;
		this.classesName = classesName;
		this.division = division;
	}

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

	public String getClassesName() {
		return classesName;
	}

	public void setClassesName(String classesName) {
		this.classesName = classesName;
	}

	public Divisions getDivision() {
		return division;
	}

	public void setDivision(Divisions division) {
		this.division = division;
	}

	@Override
	public String toString() {
		return "Classes [id=" + id + ", classesName=" + classesName + ", division=" + division + "]";
	}









	
	
}
