package com.school.students;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.session.Session;

@Entity
@Table(name = "student_tb")
public class Students {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer sid;

	@Column(name = "roll_No")
	private Integer rollno;

	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;

	@JsonIgnore
	@Column(name = "bith_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date Birthdate;

	@Column(name = "mobile_number")
	private String mobno;

	@ManyToOne
	@JoinColumn(name = "session_id")
	private Session session;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthdate() {
		return Birthdate;
	}

	public void setBirthdate(Date birthdate) {
		Birthdate = birthdate;
	}

	public String getMobno() {
		return mobno;
	}

	public void setMobno(String mobno) {
		this.mobno = mobno;
	}

	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public void setRollno(Integer rollno) {
		this.rollno = rollno;
	}

	@Override
	public String toString() {
		return "Students [sid=" + sid + ", rollno=" + rollno + ", name=" + name + ", address=" + address
				+ ", Birthdate=" + Birthdate + ", mobno=" + mobno + ", session=" + session + "]";
	}

}
