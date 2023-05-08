package com.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.entities.Classes;

@Repository
public interface ClassesRepository extends JpaRepository<Classes, Long> {

}
