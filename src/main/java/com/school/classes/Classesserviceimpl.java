package com.school.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class Classesserviceimpl implements Classesservice{

	@Autowired
	ClassesRepository classesrepository;

	@Override
	public Classes saveclasses(Classes classes) {
	
		return classesrepository.save(classes);
	}

	@Override
	public List<Classes> getAllClasses(Classes Class) {
		
		return classesrepository.findAll();
	

	}	
}
