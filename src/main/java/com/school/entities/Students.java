package com.school.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="student_tb")
public class Students {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "Roll_No.")
	private Long Rollno;
	
	@Column(name = "name")
	private String Name;
	
	@Column(name = "address")
	private String Address;
	
	@JsonIgnore
	@Column(name="date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date Birthdate;
	
	@Column(name="MobNo")
	private String Mobno;

	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRollno() {
		return Rollno;
	}

	public void setRollno(Long rollno) {
		Rollno = rollno;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Date getBirthdate() {
		return Birthdate;
	}

	public void setBirthdate(Date birthdate) {
		Birthdate = birthdate;
	}

	public String getMobno() {
		return Mobno;
	}

	public void setMobno(String mobno) {
		Mobno = mobno;
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", Rollno=" + Rollno + ", Name=" + Name + ", Address=" + Address + ", Birthdate="
				+ Birthdate + ", Mobno=" + Mobno + "]";
	}
	
	
}







