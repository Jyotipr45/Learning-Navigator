package com.crio.LearningNavigator.repositoryServices;

import java.util.List;

import com.crio.LearningNavigator.dto.StudentDto;
import com.crio.LearningNavigator.exceptions.ExamNotFoundException;
import com.crio.LearningNavigator.exceptions.StudentNotFoundException;
import com.crio.LearningNavigator.exceptions.SubjectNotEnrolledException;
import com.crio.LearningNavigator.exceptions.SubjectNotFoundException;

public interface StudentRepositoryService {

    StudentDto createStudent(String studentName);

    StudentDto findStudentById(long studentId) throws StudentNotFoundException;

    StudentDto enrollStudentInSubject(long studentId, long subjectId) throws StudentNotFoundException, SubjectNotFoundException;

    StudentDto registerStudentForExam(long studentId, long examId) throws StudentNotFoundException, ExamNotFoundException, SubjectNotEnrolledException;

    List<StudentDto> findAllStudents();

    void deleteStudent(long studentId) throws StudentNotFoundException;
}
