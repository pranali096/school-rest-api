package com.school.parent;

import org.springframework.data.domain.Sort.Direction;

public interface ParentService {

	public Iterable<Parent>getAllParentList();
	
	public Parent saveParent(Parent parent);
	
    public String getAllParentByPagination(Integer pageNo,Integer pageSize,String sortBy,Direction sortOrder,int isPagination);
	
    public Parent updateParent(Parent parents);
}
