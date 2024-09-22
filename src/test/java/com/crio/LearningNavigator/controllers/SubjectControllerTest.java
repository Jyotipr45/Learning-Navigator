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

import com.crio.LearningNavigator.controller.SubjectController;
import com.crio.LearningNavigator.dto.SubjectDto;
import com.crio.LearningNavigator.services.SubjectService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = SubjectController.class)
public class SubjectControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SubjectService subjectService;

    @Test
    public void testGetSubjectById() throws Exception {
        SubjectDto subject = new SubjectDto();
        subject.setId(1);
        subject.setName("BDT-INTV");

        when(subjectService.findSubjectById(1)).thenReturn(subject);

        mockMvc.perform(get("/subjects/{subjectId}", 1))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.name").value("BDT-INTV"));
    }
}