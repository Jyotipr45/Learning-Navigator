package com.crio.LearningNavigator.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"registeredStudents"})
public class SubjectDto {
   
    private long id;  

    private String name;

    @JsonIgnore
    private Set<StudentDto> registeredStudents;
}
