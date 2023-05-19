package com.school.divisions;

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
public class Divisionservicesimpl implements Divisionservices{
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	Divisionrepository divrepository;
	
	@Autowired 
	Util util;

	@Override
	public String getAllDivisions(Integer pageNo, Integer pageSize, String sortBy, Direction sortOrder,
			int isPagination) {
		PageRequest pageable=  PageRequest.of(pageNo, pageSize, Sort.by(sortOrder,sortBy));
		if(isPagination>0) {
			Page<Divisions> pageResult = divrepository.findAll(pageable);
			LOG.info(" Service: Page is found");
			return util.objectMapperSuccess( pageResult,"Page is found");
		}else {
			List<Divisions> list1=(List<Divisions>)divrepository.findAll();
			LOG.info(" Service: Page is  not found");
			return util.objectMapperSuccess(list1,"Page is not found") ;
		}

	}

	@Override
	public Divisions saveDivisions(Divisions div) {
		
		return  divrepository.save(div);
	}

	@Override
	public String getDivisionById(Long id) {
		Optional<Divisions> dop= divrepository.findById(id);
		if(dop.isPresent()) {
			LOG.info("Get Division  Succusefully");
			return " Get Division  Succusefully";
		}else {
			
		throw new RuntimeException(" get Division is not Succusefully" );
	}
	
	}

	@Override
	public Divisions saveDivision(Divisions divi) {

    return divrepository.save(divi);
	
}

	@Override
	public String deleteById(Long did) {
			Optional<Divisions> op = divrepository.findById(did);
			if (op.isEmpty()) {
				return " Divisions is deleted succusefully";
			}else {
				throw new RuntimeException(" Divisions is failed to delete");
			}	
	}

}







