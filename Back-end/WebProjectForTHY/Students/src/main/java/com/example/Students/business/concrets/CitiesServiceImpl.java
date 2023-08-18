package com.example.Students.business.concrets;

import com.example.Students.business.abstracts.CitiesService;
import com.example.Students.business.concrets.requests.CreateCitiesRequest;
import com.example.Students.business.concrets.requests.UpdateCitiesRequest;
import com.example.Students.business.concrets.requests.UpdateStudentRequest;
import com.example.Students.business.concrets.responses.GetAllCitiesResponse;
import com.example.Students.business.concrets.responses.GetByIdCitiesResponse;
import com.example.Students.business.concrets.responses.GetByIdStudentResponse;
import com.example.Students.core.utulities.mappers.ModelMapperService;
import com.example.Students.dataAccess.abstracts.CitiesRepository;
import com.example.Students.entities.concretes.Cities;
import com.example.Students.entities.concretes.Students;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class CitiesServiceImpl implements CitiesService {


    private CitiesRepository citiesRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllCitiesResponse> getAll() {

        List<Cities> cities = citiesRepository.findAll();

        List<GetAllCitiesResponse> citiesResponse = cities.stream()
                .map(city ->this.modelMapperService.forResponse()
                        .map(city,GetAllCitiesResponse.class)).collect(Collectors.toList());

        // iş kuralları
        return citiesResponse;
    }

    public void addCity(CreateCitiesRequest createCitiesRequest){
        Cities cities = this.modelMapperService.forRequest().map(createCitiesRequest,Cities.class);
        this.citiesRepository.save(cities);

    }

    @Override
    public void deleteCity(Long id) {

        this.citiesRepository.deleteById(id);
    }


    @Override
    public void updateCity(UpdateCitiesRequest updateCitiesRequest) {
        Cities cities = this.modelMapperService.forRequest().map(updateCitiesRequest,Cities.class);
        this.citiesRepository.save(cities);

    }

    @Override
    public GetByIdCitiesResponse getByIdCitiesResponse(Long id) {
        Cities cities = this.citiesRepository.findById(id).orElseThrow();

        GetByIdCitiesResponse response = this.modelMapperService.forResponse().map(cities,GetByIdCitiesResponse.class);

        return response;
    }



}
