package com.school.classes;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassesRepository extends PagingAndSortingRepository<Classes, Long> {


}
