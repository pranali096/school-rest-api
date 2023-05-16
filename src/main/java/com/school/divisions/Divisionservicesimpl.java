package com.school.divisions;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class Divisionservicesimpl implements Divisionservices{
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	Divisionrepository divrepository;

	@Override
	public String getAllDivisions(Integer pageNo, Integer pageSize, String sortBy, Direction sortOrder,
			int isPagination) {
		PageRequest pageable=  PageRequest.of(pageNo, pageSize, Sort.by(sortOrder,sortBy));
		if(isPagination>0) {
			Page<Divisions> pageResult = divrepository.findAll(pageable);
			LOG.info(" Service: Page is found");
			return " Service: Page is found";
		}else {
			
			return " Service : page is not found";
		}

	}

	@Override
	public Divisions saveclasses(Divisions div) {
		
		return  divrepository.save(div);
	}
	
	
}









