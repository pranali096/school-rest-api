package com.school.students;

import org.springframework.data.domain.Sort.Direction;

public interface StudentService {

	public String getAllStudents(Integer pageNo, Integer pageSize, String sortBy, Direction sortOrder,int isPagination);
	
	public Students saveStudents( Students std);
}
