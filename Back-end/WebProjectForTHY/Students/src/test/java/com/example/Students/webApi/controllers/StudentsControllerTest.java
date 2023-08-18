package com.example.Students.webApi.controllers;
import com.example.Students.business.abstracts.StudentsService;
import com.example.Students.business.concrets.requests.CreateStudentRequest;
import com.example.Students.business.concrets.requests.UpdateStudentRequest;
import com.example.Students.business.concrets.responses.GetAllStudentResponse;
import com.example.Students.business.concrets.responses.GetByIdStudentResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentsController.class)
public class StudentsControllerTest {

    @MockBean
    private StudentsService studentsService;

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private StudentsController studentsController;

    @Test
    public void testGetAllStudents() throws Exception {
        GetAllStudentResponse student1 = new GetAllStudentResponse();
        GetAllStudentResponse student2 = new GetAllStudentResponse();
        List<GetAllStudentResponse> students = Arrays.asList(student1, student2);

        when(studentsService.getAll()).thenReturn(students);

        mockMvc.perform(get("/api/students"))
                .andExpect(status().isOk()) // HTTP durumu kontrol edilir
                .andExpect(jsonPath("$").isArray()) // Dizi dönmesi beklenir
                .andExpect(jsonPath("$.length()").value(2)); // 2 elemanlı olması beklenir

        verify(studentsService, times(1)).getAll(); // studentsService.getAll() çağrısının bir kez yapıldığı doğrulanır
        verifyNoMoreInteractions(studentsService); // Başka bir çağrının yapılmadığı doğrulanır
    }

    @Test
    public void testGetStudentById() throws Exception {
        GetByIdStudentResponse studentResponse = new GetByIdStudentResponse();

        when(studentsService.getByIdStudentResponse(1L)).thenReturn(studentResponse);

        mockMvc.perform(get("/api/students/1"))
                .andExpect(status().isOk()); // HTTP durumu kontrol edilir

        verify(studentsService, times(1)).getByIdStudentResponse(1L); // studentsService.getByIdStudentResponse(1L) çağrısının bir kez yapıldığı doğrulanır
        verifyNoMoreInteractions(studentsService); // Başka bir çağrının yapılmadığı doğrulanır
    }

    @Test
    public void testAddStudent() throws Exception {
        CreateStudentRequest createStudentRequest = new CreateStudentRequest();

        mockMvc.perform(post("/api/students/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"property\":\"value\"}") // JSON içeriği buraya ekleyin
                )
                .andExpect(status().isCreated()); // HTTP durumu kontrol edilir

        verify(studentsService, times(1)).addStudent(createStudentRequest); // studentsService.addStudent(createStudentRequest) çağrısının bir kez yapıldığı doğrulanır
        verifyNoMoreInteractions(studentsService); // Başka bir çağrının yapılmadığı doğrulanır
    }

    @Test
    public void testUpdateStudent() throws Exception {
        UpdateStudentRequest updateStudentRequest = new UpdateStudentRequest();

        mockMvc.perform(put("/api/students/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"property\":\"value\"}") // JSON içeriği buraya ekleyin
                )
                .andExpect(status().isOk()); // HTTP durumu kontrol edilir

        verify(studentsService, times(1)).updateStudent(updateStudentRequest); // studentsService.updateStudent(updateStudentRequest) çağrısının bir kez yapıldığı doğrulanır
        verifyNoMoreInteractions(studentsService); // Başka bir çağrının yapılmadığı doğrulanır
    }

    @Test
    public void testDeleteStudent() throws Exception {
        mockMvc.perform(delete("/api/students/delete/1"))
                .andExpect(status().isOk()); // HTTP durumu kontrol edilir

        verify(studentsService, times(1)).deleteStudent(1L); // studentsService.deleteStudent(1L) çağrısının bir kez yapıldığı doğrulanır
        verifyNoMoreInteractions(studentsService); // Başka bir çağrının yapılmadığı doğrulanır
    }
}