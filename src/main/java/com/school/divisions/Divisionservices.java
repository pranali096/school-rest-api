package com.school.divisions;

import org.springframework.data.domain.Sort.Direction;

public interface Divisionservices {

	public String getAllDivisions(Integer pageNo, Integer pageSize, String sortBy, Direction sortOrder,
			int isPagination);
	
	
	public String saveDivisions(Divisions div);
	
	public String getDivisionById(Long id);
	
	public String updateDivision (Divisions divi);
	
    public String deleteById(Long did);
}
