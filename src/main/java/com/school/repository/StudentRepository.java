package com.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.entities.Students;

@Repository
public interface StudentRepository extends JpaRepository<Students,Integer>{

}
