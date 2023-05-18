package com.school.parent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentServiceImpl implements ParentService{

	@Autowired
	ParentRepository parentrepository;

	@Override
	public Iterable<Parent> getAllParentList() {
		return parentrepository.findAll();
	}
}
