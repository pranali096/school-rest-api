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
import com.school.classes.ClassesData;
import com.school.classes.ClassesMapper;
import com.school.util.Util;

@Service
public class ParentServiceImpl implements ParentService {
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	ParentRepository parentrepository;

	@Autowired
	Util util;

	@Override
	public String saveParent(Parent parent) {
		parentrepository.save(parent);
		LOG.info("Save Parent Succusesfully");
		return util.objectMapperSuccess(parent, "Save Parent succusesfully");
	}

	@Override
	public String getAllParentByPagination(Integer pageNo, Integer pageSize, String sortBy, Direction sortOrder,
			int isPagination) {
		PageRequest pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortOrder, sortBy));
		if (isPagination > 0) {
			Page<Parent> pageResult = parentrepository.findAll(pageable);
			LOG.info(" Service: Page is found");
			return util.objectMapperSuccess(pageResult, " Page is found");
		} else {
			List<Parent> list1 = (List<Parent>) parentrepository.findAll();
			LOG.info("Service : page is not found");
			return util.objectMapperSuccess(list1, "list of pages");
		}

	}

	@Override
	public String updateParent(Parent parents) {
		parentrepository.save(parents);
		LOG.info("Update parent Succusesfully");
		return util.objectMapperSuccess(parents, "Update parent Succusesfully");
	}

	@Override
	public String deleteById(Long id) {
		Optional<Parent> par = parentrepository.findById(id);
		if (par.isPresent()) {
			parentrepository.deleteById(id);
			LOG.info("delete parent Succusesfully");
			return util.objectMapperSuccess(par, "delete Parent Succusesfully");
		} else {
			return util.objectMapperError(par, " failed to delete parent");
		}

	}

	@Override
	public String getParentById(Long id) {
		Optional<Parent> parentid = parentrepository.findById(id);
		if (parentid.isPresent()) {
			LOG.info(" get parent details succusesfully");
			return util.objectMapperSuccess(parentid, "Get parent details succusesfully ");
		} else {
			return util.objectMapperError(parentid,"Parent details not found");
		}

	}
}
