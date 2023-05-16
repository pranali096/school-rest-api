package com.school.divisions;

import org.springframework.data.domain.Sort.Direction;

public interface Divisionservices {

	public String getAllDivisions(Integer pageNo, Integer pageSize, String sortBy, Direction sortOrder,
			int isPagination);
	
	
	public  Divisions saveclasses(Divisions div);
}
