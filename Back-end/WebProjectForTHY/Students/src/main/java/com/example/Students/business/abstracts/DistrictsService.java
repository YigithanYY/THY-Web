package com.example.Students.business.abstracts;


import com.example.Students.business.concrets.requests.CreateDistrictsRequest;
import com.example.Students.business.concrets.requests.UpdateDistrictsRequest;
import com.example.Students.business.concrets.responses.GetAllDistrictsAtSameCity;
import com.example.Students.business.concrets.responses.GetAllDistrictsResponse;
import com.example.Students.business.concrets.responses.GetByIdDistrictsResponse;
import com.example.Students.entities.concretes.Districts;

import java.util.List;

public interface DistrictsService {

    List<GetAllDistrictsResponse> getAll();
    void addDistrict(CreateDistrictsRequest createdistrictsRequest);

    void deleteDistrict(Long id);

    void updateDistrict(UpdateDistrictsRequest updateDistrictsRequest);

    GetByIdDistrictsResponse getByIdDistrictsResponse(Long id);

    List<GetAllDistrictsAtSameCity> getDistrictsByCityId(Long cityId);



}
