package com.school.session;

import org.springframework.data.domain.Sort.Direction;

public interface SessionService {

	public Session addSession(Session session);
	
	public String getAllSessionsByPagination(Integer pageNo,Integer pageSize,String sortBy,Direction sortOrder,int isPagination);

	public Session updatesissions(Session session1);
	
	public String deleteById(Integer id);
	
	public String getSessionById(Integer id1);
}
