package com.school.students;

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

	@Override
	public Students updateStudents(Students stud) {
		return studentrepo.save(stud);
	}

	@Override
	public String getStudentsById(Integer id) {
		Optional<Students> op= studentrepo.findById(id);
		if(op.isPresent()) {
			LOG.info("get student id Succusessfully");
			return util.objectMapperSuccess(op,"get student id Succusessfully");
		}else {
			throw new RuntimeException(" get Student is not Succusefully" );
		}
	
			
	}

	@Override
	public String deleteStudentById(Integer sid) {
		Optional<Students> op = studentrepo.findById(sid);
		if (op.isEmpty()) {
			return " Student is deleted succusefully";
		}else {
			throw new RuntimeException(" Student is failed to delete");
		}	
}
}

