package com.example.Students.dataAccess.abstracts;


import com.example.Students.business.concrets.responses.GetAllDistrictsAtSameCity;
import com.example.Students.entities.concretes.Districts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface DistrictsRepository extends JpaRepository<Districts,Long>{
    @Query(
            value = "SELECT d FROM Districts d WHERE d.cityId = ?1"
    )
    Collection<Districts> getDistrictsByCityId(Long cityId);
}

