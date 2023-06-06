package com.school.parent;

import org.springframework.data.domain.Sort.Direction;

public interface ParentService {

	
	public String saveParent(Parent parent);
	
    public String getAllParentByPagination(Integer pageNo,Integer pageSize,String sortBy,Direction sortOrder,int isPagination);
	
    public String updateParent(Parent parents);
    
    public String deleteById( Long id); 
    
    public String getParentById( Long id);
}
