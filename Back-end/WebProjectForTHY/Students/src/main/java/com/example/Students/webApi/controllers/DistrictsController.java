package com.example.Students.webApi.controllers;


import com.example.Students.business.abstracts.DistrictsService;
import com.example.Students.business.concrets.requests.CreateDistrictsRequest;
import com.example.Students.business.concrets.requests.UpdateDistrictsRequest;
import com.example.Students.business.concrets.responses.GetAllDistrictsAtSameCity;
import com.example.Students.business.concrets.responses.GetAllDistrictsResponse;
import com.example.Students.business.concrets.responses.GetByIdDistrictsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController // anno
@RequestMapping("/api")
public class DistrictsController {


    private DistrictsService districtsService;

    public DistrictsController(DistrictsService districtsService) {

        this.districtsService = districtsService;
    }
    @GetMapping("/districts")
    public List<GetAllDistrictsResponse> getAll() {

        return districtsService.getAll();
    }

    @GetMapping("/districts/{id}")
    public GetByIdDistrictsResponse getByIdDistrictsResponse(@PathVariable Long id) {
        return districtsService.getByIdDistrictsResponse(id);
    }
    @PostMapping("/districts/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addDistrict(@RequestBody() CreateDistrictsRequest createDistrictsRequest) {
        this.districtsService.addDistrict(createDistrictsRequest);

    }

    @PutMapping("/districts/update/{id}")
    public void updateDistrict(@RequestBody() UpdateDistrictsRequest updateDistrictsRequest) {
        this.districtsService.updateDistrict(updateDistrictsRequest);
    }

    @DeleteMapping("/districts/delete/{id}")
    public void deleteDistrict(@PathVariable Long id) {
        this.districtsService.deleteDistrict(id);
    }

    @GetMapping("/districts/bycity/{cityId}")
    public List<GetAllDistrictsAtSameCity> getDistrictsByCityId(@PathVariable Long cityId) {
        return districtsService.getDistrictsByCityId(cityId);
    }

}
