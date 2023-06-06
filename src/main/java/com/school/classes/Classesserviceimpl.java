package com.school.classes;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

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
	public String saveclasses(ClassesData dat) {
		Classes c = ClassesMapper.aClassesDataBuilder().convertToClassesData(dat);
		Classes classes = classesrepository.save(c);
		ClassesData data1 = ClassesMapper.aClassesDataBuilder().convertToClasses(classes);
		return util.objectMapperSuccess(data1, "Classes saved");
	}

	@Override

	public String getClassesById(Long id) {
		Optional<Classes> studid = classesrepository.findById(id);
		if (studid.isPresent()) {
			Classes classobj = studid.get();
			ClassesData cdto = ClassesMapper.aClassesDataBuilder().convertToClasses(classobj);
			return util.objectMapperSuccess(cdto, "Get Class By id");
		} else {
			return util.objectMapperError(studid," class not found");
		}

	}

	@Override
	public String deleteById(Long cid) {
		Optional<Classes> op = classesrepository.findById(cid);
		if (op.isPresent()) {
			classesrepository.deleteById(cid);
			LOG.info("Class details  delete");
			return util.objectMapperSuccess(op, "delete Class succusesfully");
		} else {
			return util.objectMapperError(op,"failed to delete class");
		}
	}

	@Transactional
	@Override
	public String getAllClassesByPagination(Integer pageNo, Integer pageSize, String sortBy, Direction sortOrder,
			int isPagination) {
		PageRequest page = PageRequest.of(pageNo, pageSize, Sort.by(sortOrder, sortBy));
		if (isPagination > 0) {
			Page<Classes> pageResult = classesrepository.findAll(page);
			Page<ClassesData> pagedto = pageResult.map(new Function<Classes, ClassesData>() {
				@Override
				public ClassesData apply(Classes t) {
					return ClassesMapper.aClassesDataBuilder().convertToClasses(t);
				}
			});
			LOG.info(" Service: Page is found");
			return util.objectMapperSuccess(pagedto, " Page is found");
		} else {
			List<Classes> list = (List<Classes>) classesrepository.findAll();
			LOG.info("Service : page not found");
			return util.objectMapperSuccess(list, "list of pages");
		}

	}

	@Override
	public String getAllClasses() {
		List<Classes> cl = classesrepository.findAll();
		List<ClassesData> dt = ClassesMapper.aClassesDataBuilder().convertToList(cl);
		LOG.info("Get list of all classes");
		return util.objectMapperSuccess(dt, " list of classes");
	}

	@Override
	public String updatedata(ClassesData cdto) {
		Classes cl = ClassesMapper.aClassesDataBuilder().convertToClassesData(cdto);
		Classes classes = classesrepository.save(cl);
		ClassesData d = ClassesMapper.aClassesDataBuilder().convertToClasses(classes);
		LOG.info("Class details updated ");
		return util.objectMapperSuccess(d, "Class details updated");
	}

}
