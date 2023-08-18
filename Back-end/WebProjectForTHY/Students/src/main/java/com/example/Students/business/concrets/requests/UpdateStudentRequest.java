package com.example.Students.business.concrets.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStudentRequest {
    private int studentId;
    private String FirstName;
    private String LastName;
    private String PhoneNumber;
    private Long CityId;
    private Long DistrictId;
    private String Description;
}
