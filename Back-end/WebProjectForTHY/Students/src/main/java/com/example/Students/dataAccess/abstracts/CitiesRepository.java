package com.example.Students.dataAccess.abstracts;

import com.example.Students.entities.concretes.Cities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitiesRepository extends JpaRepository<Cities,Long> {
}
