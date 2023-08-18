package com.example.Students.business.concrets.requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCitiesRequest {
    private Long cityId;
    private String cityName;
}
