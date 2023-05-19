package com.school.session;

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

import com.school.classes.Classes;
import com.school.util.Util;

@Service
public class SessionServiceImpl implements SessionService{
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


	@Autowired
	SessionRepository sessionrepo;
	@Autowired
	Util util;

	@Override
	public Session addSession(Session session) {
		return sessionrepo.save(session);
	}

	@Override
	public String getAllSessionsByPagination(Integer pageNo, Integer pageSize, String sortBy, Direction sortOrder,
			int isPagination) {
		PageRequest page=PageRequest.of(pageNo,pageSize , Sort.by(sortOrder,sortBy));
		if(isPagination>0) {
			Page<Session> pageResult = sessionrepo.findAll(page);
			LOG.info(" Service: Sissionpage is found");
			return util.objectMapperSuccess(pageResult," Page is found");
		}else {
			List<Session> list=  (List<Session>) sessionrepo.findAll();
			LOG.info ("Service : Sessionpage is not found");
			return util.objectMapperSuccess(list,"list of pages");
		}
			
		}
	
}
