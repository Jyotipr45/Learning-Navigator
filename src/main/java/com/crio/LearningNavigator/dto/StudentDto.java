package com.crio.LearningNavigator.dto;

import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"enrolledSubjects", "registeredExams"})
public class StudentDto {

    private long id;

    private String name;

    private Set<SubjectDto> enrolledSubjects;

    private Set<ExamDto> registeredExams;
    
}
