package com.school.divisions;

import org.springframework.data.domain.Sort.Direction;

public interface Divisionservices {

	public String getAllDivisions(Integer pageNo, Integer pageSize, String sortBy, Direction sortOrder,
			int isPagination);
	
	
	public Divisions saveclasses(Divisions div);
	
	public String getDivisionById(Long id);
	
	public Divisions saveDivision (Divisions divi);
	
    public String deleteById(Long did);
}
