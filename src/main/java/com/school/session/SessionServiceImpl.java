package com.school.session;

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

import com.school.classes.Classes;
import com.school.divisions.Divisions;
import com.school.util.Util;

@Service
public class SessionServiceImpl implements SessionService{
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


	@Autowired
	SessionRepository sessionrepo;
	@Autowired
	Util util;

	@Override
	public String addSession(Session session) {
		sessionrepo.save(session);
		LOG.info("Save Session Succusesfully");
		return util.objectMapperError(session, "Save Session Succusesfully");
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
			LOG.info ("Service : Sessionpage  not found");
			return util.objectMapperSuccess(list,"list of pages");
		}
			
		}

	@Override
	public String updatesissions(Session session1) {
		sessionrepo.save(session1);
		LOG.info("Update Session Succusesfully");
		return util.objectMapperSuccess(session1, "Update Session Succusesfully");
	}

	@Override
	public String deleteById(Integer id) {
		Optional<Session> op = sessionrepo.findById(id);
			if (op.isPresent()) {
				sessionrepo.deleteById(id);
				return  util.objectMapperSuccess(op, "delete Session Succusesfully");
			}else {
				return util.objectMapperError(op," failed to delete session");
			}
	}

	@Override
	public String getSessionById(Integer id1) {
		Optional<Session> sion= sessionrepo.findById(id1);
		if(sion.isPresent()) {
			LOG.info("Get Session  Succusefully");
			return util.objectMapperSuccess(sion, "Get Session  Succusefully");
		}else {
			
		return util.objectMapperError(sion,"not found session");
	}
	}
}
