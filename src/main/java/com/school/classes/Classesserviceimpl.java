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
public class Classesserviceimpl implements Classesservice {
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	ClassesRepository classesrepository;

	@Autowired
	Util util;
	@Autowired
	ClassesMapper mapper;

	@Override
	public String saveclasses(ClassesDto dto) {
		Classes c = mapper.converToClassesDto(dto);
		// return classesrepository.save(c);
		Classes classes = classesrepository.save(c);
		ClassesDto dto1 = mapper.convertToClasess(classes);
		return util.objectMapperSuccess(dto1, "Classes saved");
	}

	@Override

	
	  public String getClassesById(Long id){
	 Optional<Classes> studid =classesrepository.findById(id);
	if (studid.isPresent()) {
		Classes classobj= studid.get();
		ClassesDto cdto= mapper.convertToClasess(classobj);
		
		return util.objectMapperSuccess(cdto,"class is found");
	}else {
		return util.objectMapperError("Class not found");
	}
	
	}

	@Override
	public String deleteById(Long cid) {
		Optional<Classes> op = classesrepository.findById(cid);
		if (op.isEmpty()) {
			return " Classes is deleted succusefully";
		} else {
			throw new RuntimeException(" Classes is failed to delete");
		}
	}

	@Transactional
	@Override
	public String getAllClassesByPagination(Integer pageNo, Integer pageSize, String sortBy, Direction sortOrder,
			int isPagination) {
		PageRequest page = PageRequest.of(pageNo, pageSize, Sort.by(sortOrder, sortBy));
		if (isPagination > 0) {
			Page<Classes> pageResult = classesrepository.findAll(page);
			List<ClassesDto> csdto= mapper.convertToList(( pageResult.getContent()));
			LOG.info(" Service: Page is found");
			return util.objectMapperSuccess(csdto, " Page is found");
		} else {
			List<Classes> list = (List<Classes>) classesrepository.findAll();
			LOG.info("Service : page is not found");
			return util.objectMapperSuccess(list, "list of pages");
		}

	}

	@Override
	public String getAllClasses() {
		List<Classes> cl= classesrepository.findAll();
		List<ClassesDto> dt= mapper.convertToList(cl);
		return util.objectMapperSuccess(dt, " list of classes");
	}

	@Override
	public String updatedata(ClassesDto cdto) {
		Classes cl = mapper.converToClassesDto(cdto);
		Classes classes = classesrepository.save(cl);
		ClassesDto d = mapper.convertToClasess(classes);
		return util.objectMapperSuccess(d, "Classes updated");
	}

}
