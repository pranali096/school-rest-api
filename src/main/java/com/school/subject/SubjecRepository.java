package com.school.subject;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjecRepository extends PagingAndSortingRepository<Subject, Long>{

}
