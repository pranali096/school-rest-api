package com.school.students;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.school.divisions.Divisions;
import com.school.util.Util;

@Service
public class StudentServiceImpl implements StudentService{
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


	@Autowired
	StudentRepository studentrepo;
	@Autowired
	Util util;

	@Override
	public String getAllStudents(Integer pageNo, Integer pageSize, String sortBy, Direction sortOrder,int isPagination) {
		PageRequest  requst = PageRequest.of(pageNo, pageSize, Sort.by(sortOrder,sortBy));
		if(isPagination>0) {
			Page<Students> stpage = studentrepo.findAll(requst);
			LOG.info("Student is Found Succusessfully");
			return util.objectMapperSuccess(stpage,"Student is Found Succusessfully");
		}else {
			List<Students> stud=(List<Students>)studentrepo.findAll();
			LOG.info(" Service: Page is  not found");
			return util.objectMapperSuccess(stud,"Page is not found") ;
		}
		}

	@Override
	public Students saveStudents(Students std) {
		
		return studentrepo.save(std);
	}
			
		
	}

