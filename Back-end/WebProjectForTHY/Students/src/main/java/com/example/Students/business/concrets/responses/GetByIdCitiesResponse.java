package com.example.Students.business.concrets.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdCitiesResponse {
    private int cityId;
    private String cityName;
}
