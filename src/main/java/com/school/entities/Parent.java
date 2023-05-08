package com.school.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="parent_tb")
public class Parent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private Long id;
	
	@Column(name = "Name")
	private String Name;
	
	@Column(name = "Address")
	private String Address;
	
	@Column(name = "Email")
	private String Email;
	
	@Column(name = "mobNo.")
    private String MobNo;

	public Parent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getMobNo() {
		return MobNo;
	}

	public void setMobNo(String mobNo) {
		MobNo = mobNo;
	}

	@Override
	public String toString() {
		return "Parent [id=" + id + ", Name=" + Name + ", Address=" + Address + ", Email=" + Email + ", MobNo=" + MobNo
				+ "]";
	}
	
	
}








