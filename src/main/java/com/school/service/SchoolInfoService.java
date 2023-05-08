package com.school.service;

import java.util.List;

import com.school.entities.SchoolInfo;

public interface SchoolInfoService {
 
	public List<SchoolInfo> getAllSchoolInfo();
	
	public SchoolInfo saveschoolinfo(SchoolInfo info);
}
