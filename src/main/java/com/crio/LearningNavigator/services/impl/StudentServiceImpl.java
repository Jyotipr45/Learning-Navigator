package com.crio.LearningNavigator.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.LearningNavigator.dto.StudentDto;
import com.crio.LearningNavigator.exceptions.ExamNotFoundException;
import com.crio.LearningNavigator.exceptions.StudentNotFoundException;
import com.crio.LearningNavigator.exceptions.SubjectNotEnrolledException;
import com.crio.LearningNavigator.exceptions.SubjectNotFoundException;
import com.crio.LearningNavigator.exchanges.RegisterStudentRequest;
import com.crio.LearningNavigator.repositoryServices.StudentRepositoryService;
import com.crio.LearningNavigator.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepositoryService studentRepositoryService;

    @Override
    public StudentDto registerStudent(RegisterStudentRequest registerStudentRequest) {
        String studentName = registerStudentRequest.getStudentName();
        StudentDto student = studentRepositoryService.createStudent(studentName);
        return student;
    }

    @Override
    public StudentDto findStudentById(long studentId) throws StudentNotFoundException {
        StudentDto student = studentRepositoryService.findStudentById(studentId);
        return student;
    }

    @Override
    public StudentDto enrollStudentInSubject(long studentId, long subjectId) throws StudentNotFoundException, SubjectNotFoundException {
        StudentDto student = studentRepositoryService.enrollStudentInSubject(studentId, subjectId);
        return student;
    }

    @Override
    public StudentDto registerStudentForExam(long studentId, long examId) throws StudentNotFoundException, ExamNotFoundException, SubjectNotEnrolledException {
        StudentDto student = studentRepositoryService.registerStudentForExam(studentId, examId);
        return student;
    }

    @Override
    public List<StudentDto> findAllStudents() {
        List<StudentDto> students = studentRepositoryService.findAllStudents();
        return students;
    }

    @Override
    public void deregisterStudent(long studentId) throws StudentNotFoundException {
        studentRepositoryService.deleteStudent(studentId);
    }
    
}
