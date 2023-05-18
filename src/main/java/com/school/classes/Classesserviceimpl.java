package com.school.classes;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.school.util.Util;


@Service
public class Classesserviceimpl implements Classesservice{
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


	@Autowired
	ClassesRepository classesrepository;
	
	@Autowired
	Util util;

	@Override
	public Classes saveclasses(Classes classes) {
	
		return classesrepository.save(classes);
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
	
	@Transactional
	@Override
	public String getAllClassesByPagination(Integer pageNo, Integer pageSize, String sortBy, Direction sortOrder,
			int isPagination) {
	PageRequest page= PageRequest.of(pageNo, pageSize, Sort.by(sortOrder,sortBy));
	if(isPagination>0) {
		Page<Classes> pageResult = classesrepository.findAll(page);
		LOG.info(" Service: Page is found");
		return util.objectMapperSuccess(pageResult," Page is found");
	}else {
		List<Classes> list=  (List<Classes>) classesrepository.findAll();
		LOG.info ("Service : page is not found");
		return util.objectMapperSuccess(list,"list of pages");
	}
		
	}	


	@Override
	public Iterable<Classes> getAllClasses() {
		return classesrepository.findAll();
	}

	
		
}
