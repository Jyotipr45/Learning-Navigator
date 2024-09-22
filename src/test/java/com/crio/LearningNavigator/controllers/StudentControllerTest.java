package com.crio.LearningNavigator.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post; 
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get; 
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.crio.LearningNavigator.controller.StudentController;
import com.crio.LearningNavigator.dto.StudentDto;
import com.crio.LearningNavigator.exchanges.RegisterStudentRequest;
import com.crio.LearningNavigator.services.StudentService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    public void testRegisterStudent() throws Exception {
        String requestBody = "{\"studentName\": \"Jyoti prakash\"}";

        StudentDto student = new StudentDto();
        student.setId(1);
        student.setName("Jyoti prakash");

        when(studentService.registerStudent(any(RegisterStudentRequest.class))).thenReturn(student);

        mockMvc.perform(post("/students")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.name").value("Jyoti prakash"));

        verify(studentService, times(1)).registerStudent(any(RegisterStudentRequest.class));
    }

    @Test
    public void testGetStudentById() throws Exception {
        StudentDto student = new StudentDto();
        student.setId(1);
        student.setName("Jyoti prakash");

        when(studentService.findStudentById(1)).thenReturn(student);

        mockMvc.perform(get("/students/{studentId}", 1))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.name").value("Jyoti prakash"));
    }
}