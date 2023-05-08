package com.school.entities;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="student_tb")
public class Students {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer sid;
	
	@Column(name = "Roll_No.")
	private Integer rollno;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@JsonIgnore
	@Column(name="date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date Birthdate;
	
	@Column(name="MobNo")
	private String mobno;
	
	
	
	@OneToMany
	@JoinColumn(name="id")
	 private Set<Session> session;

	
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

		public Set<Session> getSession() {
			return session;
		}
		public void setSession(Set<Session> session) {
			this.session = session;
		}

		@Override
		public String toString() {
			return "Students [sid=" + sid + ", rollno=" + rollno + ", name=" + name + ", address=" + address
					+ ", Birthdate=" + Birthdate + ", mobno=" + mobno + ", session=" + session + "]";
		}
	
		
}







