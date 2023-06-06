package com.school.students;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

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
public class StudentServiceImpl implements StudentService {
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	StudentRepository studentrepo;
	
	@Autowired
	Util util;

	@Override
	public String getAllStudents(Integer pageNo, Integer pageSize, String sortBy, Direction sortOrder,
			int isPagination) {
		PageRequest requst = PageRequest.of(pageNo, pageSize, Sort.by(sortOrder, sortBy));
		if (isPagination > 0) {
			Page<Students> stpage = studentrepo.findAll(requst);
			Page<StudentData> psdto = stpage.map(new Function<Students, StudentData>() {

				@Override
				public StudentData apply(Students t) {

					return StudentBuilder.astudent().convertToStudent(t);
				}

			});

			LOG.info("page found Succusessfully");
			return util.objectMapperSuccess(psdto, "page Found Succusessfully");
		} else {
			List<Students> stud = (List<Students>) studentrepo.findAll();
			LOG.info(" Service: Page  not found");
			return util.objectMapperSuccess(stud, "list of  Student pages");
		}
	}

	@Override
	public String saveStudents(StudentData std) {
		Students sd = StudentBuilder.astudent().convertToStudentData(std);
		Students se = studentrepo.save(sd);
		StudentData studdata = StudentBuilder.astudent().convertToStudent(se);
		LOG.info("Save Students succusessfully");
		return util.objectMapperSuccess(studdata, "Save Students succusessfully");
	}

	@Override
	public String updateStudents(StudentData stud) {
		Students sd = StudentBuilder.astudent().convertToStudentData(stud);
		Students se = studentrepo.save(sd);
		StudentData studdata = StudentBuilder.astudent().convertToStudent(se);
		LOG.info("Update  succusessfully");
		return util.objectMapperSuccess(studdata, "Update  succusessfully");
	}

	@Override
	public String getStudentsById(Integer id) {
		Optional<Students> op = studentrepo.findById(id);
		if (op.isPresent()) {
			Students student = op.get();
			StudentData sdto = StudentBuilder.astudent().convertToStudent(student);
			LOG.info(" student id is present");
			return util.objectMapperSuccess(sdto, "id is present");
		} else {
			return util.objectMapperError(op,"id is not present");
		}

	}

	@Override
	public String deleteStudentById(Integer sid) {
		Optional<Students> op = studentrepo.findById(sid);
		if (op.isEmpty()) {
			studentrepo.deleteById(sid);
			LOG.info("Student details  delete succusefully");
			return util.objectMapperSuccess(op,"Student datails  delete succusefully");
		} else {
			return util.objectMapperError(op,"failed to delete Student datails");
		}
	}
}
