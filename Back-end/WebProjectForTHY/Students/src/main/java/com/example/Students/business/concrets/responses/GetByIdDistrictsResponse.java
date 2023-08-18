package com.example.Students.business.concrets.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdDistrictsResponse {

    private int districtId;
    private String districtName;
    private Long cityId;
}
