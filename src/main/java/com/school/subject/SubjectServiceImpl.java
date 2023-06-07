package com.school.subject;

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

import com.school.util.Util;

@Service
public class SubjectServiceImpl implements SubjectService {
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	SubjecRepository subjectrepo;
	@Autowired
	Util util;

	@Override
	public String saveSubject(Subject sub) {
			 subjectrepo.save(sub);
			LOG.info("Save Subject succusessfully");
			return  util.objectMapperSuccess(sub, "Save Subject succusessfully");
		}

	@Override
	public String updateSubject(Subject subject) {
		subjectrepo.save(subject);
		LOG.info("Update Subject succusessfully");
		return util.objectMapperSuccess(subject,"Update Subject succusessfully" );
	}

	@Override
	public String getAllSubjectsByPagination(Integer pageNo, Integer pageSize, String sortBy, Direction sortOrder,
			int isPagination) {
		PageRequest subpage = PageRequest.of(pageNo,pageSize , Sort.by(sortOrder,sortBy));
		if(isPagination>0) {
			Page<Subject> pageResult = subjectrepo.findAll(subpage);
			LOG.info(" Service: subjectpage is found");
			return util.objectMapperSuccess(pageResult," Page is found");
		}else {
			List<Subject> list=  (List<Subject>) subjectrepo.findAll();
			LOG.info ("Service : Subjectpage is not found");
			return util.objectMapperSuccess(list,"list of Subpages");
		
	}
	}

	@Override
	public String deleteSubjectById(Long id) {
		Optional<Subject> sub = subjectrepo.findById(id);
		if(sub.isPresent()) {
			subjectrepo.deleteById(id);
			LOG.info("delete subject Succuseffuly");
			return util.objectMapperSuccess(sub, "delete subject Succuseffuly");
		}else {
			return util.objectMapperError(sub, "not delete Subject sussusesfully ");
		}
	
	}



}
