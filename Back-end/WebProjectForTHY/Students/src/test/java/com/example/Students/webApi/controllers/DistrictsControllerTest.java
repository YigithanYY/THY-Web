package com.example.Students.webApi.controllers;

import com.example.Students.business.abstracts.DistrictsService;
import com.example.Students.business.concrets.requests.CreateDistrictsRequest;
import com.example.Students.business.concrets.requests.UpdateDistrictsRequest;
import com.example.Students.business.concrets.responses.GetAllDistrictsAtSameCity;
import com.example.Students.business.concrets.responses.GetAllDistrictsResponse;
import com.example.Students.business.concrets.responses.GetByIdDistrictsResponse;
import com.example.Students.webApi.controllers.DistrictsController;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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

@WebMvcTest(DistrictsController.class)
public class DistrictsControllerTest {

    @MockBean
    private DistrictsService districtsService;

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private DistrictsController districtsController;

    @Test
    public void testGetAllDistricts() throws Exception {
        GetAllDistrictsResponse district1 = new GetAllDistrictsResponse();
        GetAllDistrictsResponse district2 = new GetAllDistrictsResponse();
        List<GetAllDistrictsResponse> districts = Arrays.asList(district1, district2);

        when(districtsService.getAll()).thenReturn(districts);

        mockMvc.perform(get("/api/districts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2));

        verify(districtsService, times(1)).getAll();
        verifyNoMoreInteractions(districtsService);
    }

    @Test
    public void testGetDistrictById() throws Exception {
        GetByIdDistrictsResponse districtResponse = new GetByIdDistrictsResponse();

        when(districtsService.getByIdDistrictsResponse(1L)).thenReturn(districtResponse);

        mockMvc.perform(get("/api/districts/1"))
                .andExpect(status().isOk());

        verify(districtsService, times(1)).getByIdDistrictsResponse(1L);
        verifyNoMoreInteractions(districtsService);
    }

    @Test
    public void testAddDistrict() throws Exception {
        CreateDistrictsRequest createDistrictsRequest = new CreateDistrictsRequest();

        mockMvc.perform(post("/api/districts/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"property\":\"value\"}") // JSON içeriği buraya ekleyin
                )
                .andExpect(status().isCreated());

        verify(districtsService, times(1)).addDistrict(createDistrictsRequest);
        verifyNoMoreInteractions(districtsService);
    }

    @Test
    public void testUpdateDistrict() throws Exception {
        UpdateDistrictsRequest updateDistrictsRequest = new UpdateDistrictsRequest();

        mockMvc.perform(put("/api/districts/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"property\":\"value\"}") // JSON içeriği buraya ekleyin
                )
                .andExpect(status().isOk());

        verify(districtsService, times(1)).updateDistrict(updateDistrictsRequest);
        verifyNoMoreInteractions(districtsService);
    }

    @Test
    public void testDeleteDistrict() throws Exception {
        mockMvc.perform(delete("/api/districts/delete/1"))
                .andExpect(status().isOk());

        verify(districtsService, times(1)).deleteDistrict(1L);
        verifyNoMoreInteractions(districtsService);
    }

    @Test
    public void testGetDistrictsByCityId() throws Exception {
        GetAllDistrictsAtSameCity district1 = new GetAllDistrictsAtSameCity();
        GetAllDistrictsAtSameCity district2 = new GetAllDistrictsAtSameCity();
        List<GetAllDistrictsAtSameCity> districts = Arrays.asList(district1, district2);

        when(districtsService.getDistrictsByCityId(1L)).thenReturn(districts);

        mockMvc.perform(get("/api/districts/bycity/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2));

        verify(districtsService, times(1)).getDistrictsByCityId(1L);
        verifyNoMoreInteractions(districtsService);
    }
}
