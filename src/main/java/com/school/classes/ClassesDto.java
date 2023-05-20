package com.school.classes;

public class ClassesDto {
	private Long id;
	private String classesName;
	private String divisionName;
	private Long divisionId;
	public Long getId() {
		return id;
	}
	public String getClassesName() {
		return classesName;
	}
	public void setClassesName(String classesName) {
		this.classesName = classesName;
	}
	public String getDivisionName() {
		return divisionName;
	}
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
	public Long getDivisionId() {
		return divisionId;
	}
	public void setDivisionId(Long divisionId) {
		this.divisionId = divisionId;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "ClassesDto [id=" + id + ", classesName=" + classesName + ", divisionName=" + divisionName
				+ ", divisionId=" + divisionId + "]";
	}


	
	
	
}
