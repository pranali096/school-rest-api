package com.school.divisions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Divisionrepository extends JpaRepository<Divisions, Long>{
	

}
