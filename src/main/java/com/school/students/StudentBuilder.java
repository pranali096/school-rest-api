package com.school.students;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.school.classes.Classes;
import com.school.divisions.Divisions;
import com.school.parent.Parent;
import com.school.session.Session;

@Component
public class StudentBuilder {
	public static StudentBuilder astudent() {
		return new StudentBuilder();
	}

	public Students convertToStudentData(StudentData stdata) {

		Parent pa = Parent.builder().address(stdata.getPaddress()).email(stdata.getEmail()).id(stdata.getPid())
				.mobNo(stdata.getPmobNo()).name(stdata.getPname()).build();
		Classes cla = Classes.builder().id(stdata.getCid()).classesName(stdata.getClassesName()).build();
		
		Session sion =Session.builder().id(stdata.getSeid()).year(stdata.getSeyear())
				.build();

		Students std = Students.builder().address(stdata.getAddress()).name(stdata.getName()).mobno(stdata.getMobno())
				.Birthdate(stdata.getBirthdate())
				.rollno(stdata.getRollno()).sid(stdata.getSid()).parent(pa).Clasessobj(cla).session(sion)
				.build();
		return std;

	}
	
	StudentData convertToStudent(Students stud) {
		StudentData data= StudentData.builder()
				.address(stud.getAddress()).mobno(stud.getMobno()).rollno(stud.getRollno()).sid(stud.getSid()).Birthdate(stud.getBirthdate())
				.cid(stud.getClasessobj().getId())
				.classesName(stud.getClasessobj().getClassesName())
				.did(stud.getClasessobj().getDivision().getDid())
				.Division(stud.getClasessobj().getDivision().getDivision())
				.email(stud.getParent().getEmail())
				.name(stud.getName()).paddress(stud.getParent().getAddress()).pid(stud.getParent().getId())
				.pmobNo(stud.getParent().getMobNo()).pname(stud.getParent().getName())
				.seid(stud.getSession().getId()).seyear(stud.getSession().getYear())
				.build();
		
		return data;
		
	}
	public List<StudentData> convertToList(List<Students> slist){
		List<StudentData> sdlist= new ArrayList<>();
		for(Students ts: slist) {
			
			StudentData datas = StudentData.builder()
					.address(ts.getAddress()).mobno(ts.getMobno()).rollno(ts.getRollno()).sid(ts.getSid())
					.cid(ts.getClasessobj().getId()).Birthdate(ts.getBirthdate())
					.classesName(ts.getClasessobj().getClassesName())
					.did(ts.getClasessobj().getDivision().getDid())
					.Division(ts.getClasessobj().getDivision().getDivision())
					.email(ts.getParent().getEmail())
					.name(ts.getName()).paddress(ts.getParent().getAddress()).pid(ts.getParent().getId())
					.pmobNo(ts.getParent().getMobNo()).pname(ts.getParent().getName())
					.seid(ts.getSession().getId()).seyear(ts.getSession().getYear())
					
					.build(); sdlist.add(datas);
		
			
		}
		
		return sdlist;
		
	}
	

}
