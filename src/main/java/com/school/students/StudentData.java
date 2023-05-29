package com.school.students;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentData {

	private Integer sid;
	private Integer rollno;
	private String name;
	private String address;
	private String mobno;
	private Integer seid;
	private String seyear;
	private Long did;
	private String Division;
	private Long pid;
	private String pname;
	private String paddress;
	private String email;
	private String pmobNo;
	private Long cid;
	private String classesName;
	private Date Birthdate;

}
