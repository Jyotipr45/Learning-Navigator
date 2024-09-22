package com.crio.LearningNavigator.services;

import java.util.List;

import com.crio.LearningNavigator.dto.StudentDto;
import com.crio.LearningNavigator.exceptions.ExamNotFoundException;
import com.crio.LearningNavigator.exceptions.StudentNotFoundException;
import com.crio.LearningNavigator.exceptions.SubjectNotEnrolledException;
import com.crio.LearningNavigator.exceptions.SubjectNotFoundException;
import com.crio.LearningNavigator.exchanges.RegisterStudentRequest;

public interface StudentService {

    StudentDto registerStudent(RegisterStudentRequest registerStudentRequest);

    StudentDto findStudentById(long studentId) throws StudentNotFoundException;

    StudentDto enrollStudentInSubject(long studentId, long subjectId) throws StudentNotFoundException, SubjectNotFoundException;

    StudentDto registerStudentForExam(long studentId, long examId) throws StudentNotFoundException, ExamNotFoundException, SubjectNotEnrolledException;

    List<StudentDto> findAllStudents();

    void deregisterStudent(long studentId) throws StudentNotFoundException;
    
}
