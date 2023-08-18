package com.example.Students.business.concrets.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllDistrictsResponse {
    private int districtId;
    private String districtName;
    private int cityId;
}
