package com.school.classes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

	@Override
	public String getClassesById(Long id) {
		Optional<Classes> studid = classesrepository.findById(id);
		if (studid.isPresent()) {
			return "Classes id is Found";
		}else {
			throw new RuntimeException(" Classes id not Found");
	
	}

	}

	@Override
	public String deleteById(Long cid) {
		Optional<Classes> op = classesrepository.findById(cid);
		if (op.isEmpty()) {
			return " Classes is deleted succusefully";
		}else {
			throw new RuntimeException(" Classes is failed to delete");
		}
	}
		
}
