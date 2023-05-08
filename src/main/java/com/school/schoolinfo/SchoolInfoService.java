package com.school.schoolinfo;

import java.util.List;

public interface SchoolInfoService {
 
	public List<SchoolInfo> getAllSchoolInfo();
	
	public SchoolInfo saveschoolinfo(SchoolInfo info);
	
	public SchoolInfo updateschoolonfo(SchoolInfo sinfo);
}
