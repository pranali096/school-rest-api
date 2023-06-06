package com.school.schoolinfo;

import java.util.List;

public interface SchoolInfoService {
 
	public List<SchoolInfo> getAllSchoolInfo();
	
	public String saveschoolinfo(SchoolInfo info);
	
	public String updateschoolonfo(SchoolInfo sinfo);
}
