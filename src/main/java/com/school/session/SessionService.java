package com.school.session;

import org.springframework.data.domain.Sort.Direction;

public interface SessionService {

	public Session addSession(Session session);
	
	public String getAllSessionsByPagination(Integer pageNo,Integer pageSize,String sortBy,Direction sortOrder,int isPagination);

}
