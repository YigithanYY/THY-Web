package com.example.Students.business.concrets.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllStudentResponse {
    private int studentId;
    private String FirstName;
    private String LastName;
    private String PhoneNumber;
    private Long CityId;
    private Long DistrictId;
    private String Description;
}
