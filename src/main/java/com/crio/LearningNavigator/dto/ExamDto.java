package com.crio.LearningNavigator.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"enrolledStudents"})
public class ExamDto {
   
    private long id;

    private SubjectDto subject;

    @JsonIgnore
    private Set<StudentDto> enrolledStudents;
}
