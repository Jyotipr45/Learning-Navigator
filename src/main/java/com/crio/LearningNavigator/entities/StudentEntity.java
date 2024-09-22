package com.crio.LearningNavigator.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(exclude = {"enrolledSubjects", "registeredExams"})
@Table(name = "students")
public class StudentEntity {
    
    @Id
    @Column(name = "studentId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "studentName")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<SubjectEntity> enrolledSubjects = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<ExamEntity> registeredExams = new HashSet<>();

}
