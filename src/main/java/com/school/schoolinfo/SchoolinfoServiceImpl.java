package com.school.schoolinfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SchoolinfoServiceImpl implements SchoolInfoService{

	@Autowired 
	SchoolInfoRepo inforepo;

	@Override
	public List<SchoolInfo>getAllSchoolInfo() {
		
		return inforepo.findAll();
	}

	@Override
	public SchoolInfo saveschoolinfo(SchoolInfo info) {
		
		return inforepo.save(info);
	}

	@Override
	public SchoolInfo updateschoolonfo(SchoolInfo sinfo) {
		
		return inforepo.save(sinfo);
	}

	


	
	
	
}
