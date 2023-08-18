package com.example.Students.business.abstracts;

import com.example.Students.business.concrets.requests.CreateStudentRequest;
import com.example.Students.business.concrets.requests.UpdateStudentRequest;
import com.example.Students.business.concrets.responses.GetAllStudentResponse;
import com.example.Students.business.concrets.responses.GetByIdStudentResponse;

import java.util.List;

public interface StudentsService {
    List<GetAllStudentResponse> getAll();

    void addStudent(CreateStudentRequest createStudentRequest);
    void deleteStudent(Long id);
    void updateStudent(UpdateStudentRequest createStudentRequest);
    GetByIdStudentResponse getByIdStudentResponse(Long id);
}
