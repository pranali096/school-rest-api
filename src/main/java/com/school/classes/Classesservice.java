package com.school.classes;

import org.springframework.data.domain.Sort.Direction;


public interface Classesservice {

	public  Classes saveclasses( Classes classes);
	
	public Iterable<Classes> getAllClasses();
	
	public String getClassesById(Long id);
	
	public String deleteById(Long cid);
	
	public String getAllClassesByPagination(Integer pageNo,Integer pageSize,String sortBy,Direction sortOrder,int isPagination);
	
}
