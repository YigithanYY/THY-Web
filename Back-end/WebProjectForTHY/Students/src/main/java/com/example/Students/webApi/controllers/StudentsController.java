package com.example.Students.webApi.controllers;


import com.example.Students.business.abstracts.StudentsService;
import com.example.Students.business.concrets.requests.CreateStudentRequest;
import com.example.Students.business.concrets.requests.UpdateStudentRequest;
import com.example.Students.business.concrets.responses.GetAllStudentResponse;
import com.example.Students.business.concrets.responses.GetByIdStudentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController // anno
@RequestMapping("/api")
public class StudentsController {
    private StudentsService studentsService;


    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping("/students")
    public List<GetAllStudentResponse> getAll() {
        return studentsService.getAll();
    }


    @GetMapping("/students/{id}")
    public GetByIdStudentResponse getStudentById(@PathVariable Long id) {
        return studentsService.getByIdStudentResponse(id);
    }

    @PostMapping("/students/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addStudent(@RequestBody() CreateStudentRequest createStudentRequest) {
        this.studentsService.addStudent(createStudentRequest);

    }

    @PutMapping("/students/update/{id}")
    public void updateStudent(@RequestBody() UpdateStudentRequest updateStudentRequest) {
        this.studentsService.updateStudent(updateStudentRequest);
    }

    @DeleteMapping("/students/delete/{id}")
    public void deleteStudent(@PathVariable Long id) {
        this.studentsService.deleteStudent(id);

    }





}
