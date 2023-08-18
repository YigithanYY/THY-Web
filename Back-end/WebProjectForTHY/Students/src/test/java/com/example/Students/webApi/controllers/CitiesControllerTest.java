package com.example.Students.webApi.controllers;
import com.example.Students.business.abstracts.CitiesService;
import com.example.Students.business.concrets.requests.CreateCitiesRequest;
import com.example.Students.business.concrets.requests.UpdateCitiesRequest;
import com.example.Students.business.concrets.responses.GetAllCitiesResponse;
import com.example.Students.business.concrets.responses.GetByIdCitiesResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CitiesController.class)
public class CitiesControllerTest {

    @MockBean
    private CitiesService citiesService;

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private CitiesController citiesController;

    @Test
    public void testGetAllCities() throws Exception {
        GetAllCitiesResponse city1 = new GetAllCitiesResponse();
        GetAllCitiesResponse city2 = new GetAllCitiesResponse();
        List<GetAllCitiesResponse> cities = Arrays.asList(city1, city2);

        when(citiesService.getAll()).thenReturn(cities);

        mockMvc.perform(get("/api/cities"))
                .andExpect(status().isOk()) // HTTP durumu kontrol edilir
                .andExpect(jsonPath("$").isArray()) // Dizi dönmesi beklenir
                .andExpect(jsonPath("$.length()").value(2)); // 2 elemanlı olması beklenir

        verify(citiesService, times(1)).getAll(); // citiesService.getAll() çağrısının bir kez yapıldığı doğrulanır
        verifyNoMoreInteractions(citiesService); // Başka bir çağrının yapılmadığı doğrulanır
    }

    @Test
    public void testGetCityById() throws Exception {
        GetByIdCitiesResponse cityResponse = new GetByIdCitiesResponse();

        when(citiesService.getByIdCitiesResponse(1L)).thenReturn(cityResponse);

        mockMvc.perform(get("/api/cities/1"))
                .andExpect(status().isOk()); // HTTP durumu kontrol edilir

        verify(citiesService, times(1)).getByIdCitiesResponse(1L); // citiesService.getByIdCitiesResponse(1L) çağrısının bir kez yapıldığı doğrulanır
        verifyNoMoreInteractions(citiesService); // Başka bir çağrının yapılmadığı doğrulanır
    }

    @Test
    public void testAddCity() throws Exception {
        CreateCitiesRequest createCitiesRequest = new CreateCitiesRequest();

        mockMvc.perform(post("/api/cities/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"property\":\"value\"}") // JSON içeriği buraya ekleyin
                )
                .andExpect(status().isCreated()); // HTTP durumu kontrol edilir

        verify(citiesService, times(1)).addCity(createCitiesRequest); // citiesService.addCity(createCitiesRequest) çağrısının bir kez yapıldığı doğrulanır
        verifyNoMoreInteractions(citiesService); // Başka bir çağrının yapılmadığı doğrulanır
    }

    @Test
    public void testUpdateCity() throws Exception {
        UpdateCitiesRequest updateCitiesRequest = new UpdateCitiesRequest();

        mockMvc.perform(put("/api/cities/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"property\":\"value\"}") // JSON içeriği buraya ekleyin
                )
                .andExpect(status().isOk()); // HTTP durumu kontrol edilir

        verify(citiesService, times(1)).updateCity(updateCitiesRequest); // citiesService.updateCity(updateCitiesRequest) çağrısının bir kez yapıldığı doğrulanır
        verifyNoMoreInteractions(citiesService); // Başka bir çağrının yapılmadığı doğrulanır
    }

    @Test
    public void testDeleteCity() throws Exception {
        mockMvc.perform(delete("/api/cities/delete/1"))
                .andExpect(status().isOk()); // HTTP durumu kontrol edilir

        verify(citiesService, times(1)).deleteCity(1L); // citiesService.deleteCity(1L) çağrısının bir kez yapıldığı doğrulanır
        verifyNoMoreInteractions(citiesService); // Başka bir çağrının yapılmadığı doğrulanır
    }
}
