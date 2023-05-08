package com.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.entities.SchoolInfo;

@Repository
public interface SchoolInfoRepo extends JpaRepository<SchoolInfo, Integer> {

}
