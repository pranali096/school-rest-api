package com.school.session;

import org.springframework.data.domain.Sort.Direction;

public interface SessionService {

	public String addSession(Session session);
	
	public String getAllSessionsByPagination(Integer pageNo,Integer pageSize,String sortBy,Direction sortOrder,int isPagination);

	public String updatesissions(Session session1);
	
	public String deleteById(Integer id);
	
	public String getSessionById(Integer id1);
}
