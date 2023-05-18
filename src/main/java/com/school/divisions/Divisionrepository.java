package com.school.divisions;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Divisionrepository extends PagingAndSortingRepository<Divisions, Long>{

	

}
