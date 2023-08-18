package com.example.Students.webApi.controllers;


import com.example.Students.business.abstracts.CitiesService;
import com.example.Students.business.concrets.requests.CreateCitiesRequest;
import com.example.Students.business.concrets.requests.UpdateCitiesRequest;
import com.example.Students.business.concrets.responses.GetAllCitiesResponse;
import com.example.Students.business.concrets.responses.GetByIdCitiesResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController // anno
@RequestMapping("/api")
public class CitiesController {
    private CitiesService citiesService;

    public CitiesController(CitiesService citiesService) {

        this.citiesService = citiesService;
    }
    @GetMapping("/cities")
    public List<GetAllCitiesResponse> getAll() {

        return citiesService.getAll();
    }
    @GetMapping("/cities/{id}")
    public GetByIdCitiesResponse getByIdCitiesResponse(@PathVariable Long id) {
        return citiesService.getByIdCitiesResponse(id);
    }
    @PostMapping("/cities/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addCity(@RequestBody() CreateCitiesRequest createCitiesRequest) {
        this.citiesService.addCity(createCitiesRequest);

    }
    @PutMapping("/cities/update/{id}")
    public void updateCity(@RequestBody() UpdateCitiesRequest updateCitiesRequest) {
        this.citiesService.updateCity(updateCitiesRequest);
    }

    @DeleteMapping("/cities/delete/{id}")
    public void deleteCity(@PathVariable Long id) {
        this.citiesService.deleteCity(id);
    }

}
