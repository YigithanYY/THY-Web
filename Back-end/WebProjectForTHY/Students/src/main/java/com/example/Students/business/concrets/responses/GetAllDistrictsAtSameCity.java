package com.example.Students.business.concrets.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllDistrictsAtSameCity {
    private int districtId;
    private String districtName;
    private Long cityId;
}
