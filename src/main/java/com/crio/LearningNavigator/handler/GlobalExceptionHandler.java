package com.crio.LearningNavigator.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.crio.LearningNavigator.exceptions.ExamNotFoundException;
import com.crio.LearningNavigator.exceptions.StudentNotFoundException;
import com.crio.LearningNavigator.exceptions.SubjectNotEnrolledException;
import com.crio.LearningNavigator.exceptions.SubjectNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    ResponseEntity<String> handleStudentNotFoundException(StudentNotFoundException ex) {
        String message = ex.getMessage();
        return ResponseEntity.status(404).body(message);
    }

    @ExceptionHandler(SubjectNotFoundException.class)
    ResponseEntity<String> handleSubjectNotFoundException(SubjectNotFoundException ex) {
        String message = ex.getMessage();
        return ResponseEntity.status(404).body(message);
    }

    @ExceptionHandler(ExamNotFoundException.class)
    ResponseEntity<String> handleExamNotFoundException(ExamNotFoundException ex) {
        String message = ex.getMessage();
        return ResponseEntity.status(404).body(message);
    }

    @ExceptionHandler(SubjectNotEnrolledException.class)
    ResponseEntity<String> handleSubjectNotEnrolledException(SubjectNotEnrolledException ex) {
        String message = ex.getMessage();
        return ResponseEntity.status(403).body(message);
    }
}
