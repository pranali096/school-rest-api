package com.school.classes;

import org.springframework.data.domain.Sort.Direction;


public interface Classesservice {

	public  String saveclasses( ClassesData dat);
	
	public String getAllClasses();
	
	public String getClassesById(Long id);
	
	public String deleteById(Long cid);
	
	public String getAllClassesByPagination(Integer pageNo,Integer pageSize,String sortBy,Direction sortOrder,int isPagination);
	
	public String updatedata(ClassesData cdto);
}
