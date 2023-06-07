package com.school.subject;

import org.springframework.data.domain.Sort.Direction;

public interface SubjectService {
	public String saveSubject(Subject sub);
	
	public String updateSubject(Subject subject);
	
	public String getAllSubjectsByPagination(Integer pageNo,Integer pageSize,String sortBy,Direction sortOrder,int isPagination);
	
	public String deleteSubjectById(Long id);
	


}
