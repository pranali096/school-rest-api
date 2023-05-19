package com.school.session;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends PagingAndSortingRepository<Session, Long>{

}
