package com.example.Students.business.concrets;


import com.example.Students.business.abstracts.DistrictsService;
import com.example.Students.business.concrets.requests.CreateDistrictsRequest;
import com.example.Students.business.concrets.requests.UpdateDistrictsRequest;
import com.example.Students.business.concrets.responses.GetAllDistrictsResponse;
import com.example.Students.business.concrets.responses.GetByIdDistrictsResponse;
import com.example.Students.business.concrets.responses.GetAllDistrictsAtSameCity;
import com.example.Students.core.utulities.mappers.ModelMapperService;
import com.example.Students.dataAccess.abstracts.DistrictsRepository;

import com.example.Students.entities.concretes.Districts;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class DistrictsServiceImpl implements DistrictsService {

    private DistrictsRepository districtsRepository;
    private ModelMapperService modelMapperService;


    @Override
    public List<GetAllDistrictsResponse> getAll() {

        List<Districts> districts = districtsRepository.findAll();

        List<GetAllDistrictsResponse> districtsResponse = districts.stream()
                .map(district ->this.modelMapperService.forResponse()
                        .map(district,GetAllDistrictsResponse.class)).collect(Collectors.toList());

        // iş kuralları
        return districtsResponse;
    }


    public void addDistrict(CreateDistrictsRequest createDistrictsRequest){
        Districts districts = this.modelMapperService.forRequest().map(createDistrictsRequest,Districts.class);
        this.districtsRepository.save(districts);

    }

    @Override
    public void deleteDistrict(Long id) {

        this.districtsRepository.deleteById(id);
    }


    @Override
    public void updateDistrict(UpdateDistrictsRequest updateDistrictsRequest) {
        Districts districts = this.modelMapperService.forRequest().map(updateDistrictsRequest,Districts.class);
        this.districtsRepository.save(districts);

    }

    @Override
    public GetByIdDistrictsResponse getByIdDistrictsResponse(Long id) {
        Districts districts = this.districtsRepository.findById(id).orElseThrow();

        GetByIdDistrictsResponse response = this.modelMapperService.forResponse().map(districts,GetByIdDistrictsResponse.class);

        return response;
    }

    @Override
    public List<GetAllDistrictsAtSameCity> getDistrictsByCityId(Long cityId) {
        Collection<Districts> districts = this.districtsRepository.getDistrictsByCityId(cityId);

        List<GetAllDistrictsAtSameCity> response = districts.stream()
                .map(district -> this.modelMapperService.forResponse()
                        .map(district, GetAllDistrictsAtSameCity.class)).collect(Collectors.toList());

        return response;
    }
}