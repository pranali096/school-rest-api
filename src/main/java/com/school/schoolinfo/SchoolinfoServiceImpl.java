package com.school.schoolinfo;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.util.Util;

@Service
public class SchoolinfoServiceImpl implements SchoolInfoService {
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	SchoolInfoRepo inforepo;
	@Autowired
	Util util;

	@Override
	public List<SchoolInfo> getAllSchoolInfo() {

		return inforepo.findAll();
	}

	@Override
	public String saveschoolinfo(SchoolInfo info) {
		inforepo.save(info);
		LOG.info("Save School Succussesfully");
		return util.objectMapperSuccess(info, "Save School Succussesfully");
	}

	@Override
	public String updateschoolonfo(SchoolInfo sinfo) {
		inforepo.save(sinfo);
		LOG.info("Update school Succussesfully");
		return util.objectMapperSuccess(sinfo, "Update School Succussesfully");
	}

}
