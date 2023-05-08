package com.school.schoolinfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SchoolInfoRepo extends JpaRepository<SchoolInfo, Integer> {

}
