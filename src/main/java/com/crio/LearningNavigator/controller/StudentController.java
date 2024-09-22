package com.crio.LearningNavigator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crio.LearningNavigator.dto.StudentDto;
import com.crio.LearningNavigator.exceptions.ExamNotFoundException;
import com.crio.LearningNavigator.exceptions.StudentNotFoundException;
import com.crio.LearningNavigator.exceptions.SubjectNotEnrolledException;
import com.crio.LearningNavigator.exceptions.SubjectNotFoundException;
import com.crio.LearningNavigator.exchanges.GetAllStudentsResponse;
import com.crio.LearningNavigator.exchanges.RegisterStudentRequest;
import com.crio.LearningNavigator.services.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(StudentController.STUDENT_API_ENDPOINT)
public class StudentController {
    public static final String STUDENT_API_ENDPOINT = "/students";

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDto> registerStudent(@Valid @RequestBody RegisterStudentRequest registerStudentRequest) {
        StudentDto student = studentService.registerStudent(registerStudentRequest);
        return ResponseEntity.ok().body(student);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable(value = "studentId") long studentId) throws StudentNotFoundException {
        StudentDto student = studentService.findStudentById(studentId);
        return ResponseEntity.ok().body(student);
    }

    @PutMapping("/{studentId}/subject/{subjectId}")
    public ResponseEntity<StudentDto> enrollStudentInSubject(@PathVariable long studentId, @PathVariable long subjectId) throws StudentNotFoundException, SubjectNotFoundException {
        StudentDto student = studentService.enrollStudentInSubject(studentId, subjectId);
        return ResponseEntity.ok().body(student);
    }

    @PutMapping("/{studentId}/exam/{examId}")
    public ResponseEntity<StudentDto> registerStudentForExam(@PathVariable long studentId, @PathVariable long examId) throws StudentNotFoundException, ExamNotFoundException, SubjectNotEnrolledException {
        StudentDto student = studentService.registerStudentForExam(studentId, examId);
        return ResponseEntity.ok().body(student);
    }

    @GetMapping
    public ResponseEntity<GetAllStudentsResponse> getAllStudents() {
        List<StudentDto> students = studentService.findAllStudents();
        GetAllStudentsResponse getAllStudentsResponse = new GetAllStudentsResponse(students);
        return ResponseEntity.ok().body(getAllStudentsResponse);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deregisterStudent(@PathVariable long studentId) throws StudentNotFoundException {
        String message = "Successfully deleted student with ID: " + String.valueOf(studentId);
        studentService.deregisterStudent(studentId);
        return ResponseEntity.ok().body(message);
    }
}
