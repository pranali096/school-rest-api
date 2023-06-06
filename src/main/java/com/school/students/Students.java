package com.school.students;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.classes.Classes;
import com.school.parent.Parent;
import com.school.session.Session;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "student_tb")
public class Students {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

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

	@OneToOne
	@JoinColumn(name = "session_id")
	private Session session;
	
	
    @OneToOne
    @JoinColumn(name = "Classes_id")
    private Classes Clasessobj;
    
    @OneToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;





}
