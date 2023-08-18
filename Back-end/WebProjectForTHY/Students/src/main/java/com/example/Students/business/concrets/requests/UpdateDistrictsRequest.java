package com.example.Students.business.concrets.requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDistrictsRequest {
    private Long districtId;
    private String districtName;
    private Long cityId;
}
