package com.example.Students.business.abstracts;

import com.example.Students.business.concrets.requests.CreateCitiesRequest;
import com.example.Students.business.concrets.requests.UpdateCitiesRequest;
import com.example.Students.business.concrets.responses.GetAllCitiesResponse;
import com.example.Students.business.concrets.responses.GetByIdCitiesResponse;

import java.util.List;


public interface CitiesService {
    List<GetAllCitiesResponse> getAll();
    void addCity(CreateCitiesRequest createcitiesRequest);

    void deleteCity(Long id);

    void updateCity(UpdateCitiesRequest createcitiesRequest);

    GetByIdCitiesResponse getByIdCitiesResponse(Long id);
}
