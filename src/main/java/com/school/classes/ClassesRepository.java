package com.school.classes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassesRepository extends PagingAndSortingRepository<Classes, Long> {

	List<Classes> findAll();
}
