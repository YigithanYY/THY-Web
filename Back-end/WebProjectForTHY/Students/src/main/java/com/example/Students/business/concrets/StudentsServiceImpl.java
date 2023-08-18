package com.example.Students.business.concrets;

import com.example.Students.business.abstracts.StudentsService;
import com.example.Students.business.concrets.requests.CreateStudentRequest;
import com.example.Students.business.concrets.requests.UpdateStudentRequest;
import com.example.Students.business.concrets.responses.GetAllStudentResponse;
import com.example.Students.business.concrets.responses.GetByIdStudentResponse;
import com.example.Students.core.utulities.mappers.ModelMapperService;
import com.example.Students.dataAccess.abstracts.StudentsRepository;
import com.example.Students.entities.concretes.Students;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentsServiceImpl implements StudentsService {

    private  StudentsRepository studentsRepository;
    private  ModelMapperService modelMapperService;

    @Override
    public List<GetAllStudentResponse> getAll() {

        List<Students> students = studentsRepository.findAll();

        List<GetAllStudentResponse> studentResponse = students.stream()
                .map(student ->this.modelMapperService.forResponse()
                        .map(student,GetAllStudentResponse.class)).collect(Collectors.toList());


        // iş kuralları
        return studentResponse;
    }
    public void addStudent(CreateStudentRequest createStudentRequest){
        Students students = this.modelMapperService.forRequest().map(createStudentRequest,Students.class);
        this.studentsRepository.save(students);

    }

    @Override
    public void deleteStudent(Long id) {
        this.studentsRepository.deleteById(id);
    }

    @Override
    public void updateStudent(UpdateStudentRequest updateStudentRequest) {
        Students students = this.modelMapperService.forRequest().map(updateStudentRequest,Students.class);
        this.studentsRepository.save(students);


    }
    @Override
    public GetByIdStudentResponse getByIdStudentResponse(Long id) {
        Students students = this.studentsRepository.findById(id).orElseThrow();

        GetByIdStudentResponse response = this.modelMapperService.forResponse().map(students,GetByIdStudentResponse.class);

        return response;
    }


}
