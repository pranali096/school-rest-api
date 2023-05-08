package com.school.classes;

import java.util.List;
import java.util.Optional;


public interface Classesservice {

	public  Classes saveclasses( Classes classes);
	
	public List<Classes> getAllClasses(Classes Class);
	
	public String getClassesById(Long id);
	
}
