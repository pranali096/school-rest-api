package com.school.divisions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Divisionservicesimpl implements Divisionservices{

	@Autowired
	Divisionrepository divrepository;
}
