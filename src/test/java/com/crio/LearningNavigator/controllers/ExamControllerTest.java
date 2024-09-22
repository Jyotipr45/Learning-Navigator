package com.crio.LearningNavigator.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get; 
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.crio.LearningNavigator.controller.ExamController;
import com.crio.LearningNavigator.dto.ExamDto;
import com.crio.LearningNavigator.dto.SubjectDto;
import com.crio.LearningNavigator.services.ExamService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ExamController.class)
public class ExamControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExamService examService;

    @Test
    public void testGetExamById() throws Exception {
        SubjectDto subject = new SubjectDto();
        subject.setId(1);
        subject.setName("BDT-INTV");
        
        ExamDto exam = new ExamDto();
        exam.setId(1);
        exam.setSubject(subject);

        when(examService.findExamById(1)).thenReturn(exam);

        mockMvc.perform(get("/exams/{examId}", 1))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.subject.name").value("BDT-INTV"));
    }

}