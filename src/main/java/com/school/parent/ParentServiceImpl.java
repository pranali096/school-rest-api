package com.school.parent;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.school.classes.Classes;
import com.school.util.Util;

@Service
public class ParentServiceImpl implements ParentService{
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	ParentRepository parentrepository;
	
	@Autowired
	Util util;


	@Override
	public Parent saveParent(Parent parent) {
		return parentrepository.save(parent);
	}

	@Override
	public String getAllParentByPagination(Integer pageNo, Integer pageSize, String sortBy, Direction sortOrder,
			int isPagination) {
		PageRequest pageable= PageRequest.of(pageNo, pageSize,Sort.by(sortOrder,sortBy));
		if(isPagination>0) {
			Page<Parent> pageResult = parentrepository.findAll(pageable);
			LOG.info(" Service: Page is found");
			return util.objectMapperSuccess(pageResult," Page is found");
		}else {
			List<Parent> list1=  (List<Parent>) parentrepository.findAll();
			LOG.info ("Service : page is not found");
			return util.objectMapperSuccess(list1,"list of pages");
		}
		
	}

	@Override
	public Parent updateParent(Parent parents) {
		return parentrepository.save(parents);
	}

	@Override
	public String deleteById(Long id) {
		Optional<Parent> par= parentrepository.findById(id);
		if (par.isEmpty()) {
			return " Parent is deleted succusefully";
		}else {
			throw new RuntimeException(" Parent is failed to delete");
		}
	
	}
}
