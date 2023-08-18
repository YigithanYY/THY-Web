package com.example.Students.dataAccess.abstracts;

import com.example.Students.entities.concretes.Students;
import org.springframework.data.jpa.repository.JpaRepository;



public interface StudentsRepository extends JpaRepository<Students,Long> {
}