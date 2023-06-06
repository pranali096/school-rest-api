package com.school.branch;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "branch_tb")
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "addres")
	private String adress;

	@Column(name = "contactNo")
	private String contactNo;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "confirmpassword")
	private String confirmPassword;
	
	@Column(name = "personname")
	private String personName;
	
	@Column(name = "personAdress")
	private String personAdress;
	
	@Column(name = "personEmail")
	private String personEmail;
	
	@Column(name = "personContactNo")
	private String personContactNo;

}
