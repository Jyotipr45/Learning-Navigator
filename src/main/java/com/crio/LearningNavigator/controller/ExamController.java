package com.crio.LearningNavigator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crio.LearningNavigator.dto.ExamDto;
import com.crio.LearningNavigator.exceptions.ExamNotFoundException;
import com.crio.LearningNavigator.exceptions.SubjectNotFoundException;
import com.crio.LearningNavigator.exchanges.CreateExamRequest;
import com.crio.LearningNavigator.exchanges.GetAllExamsResponse;
import com.crio.LearningNavigator.services.ExamService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(ExamController.EXAM_API_ENDPOINT)
public class ExamController {
    public static final String EXAM_API_ENDPOINT = "/exams";

    @Autowired
    private ExamService examService;

    @PostMapping
    public ResponseEntity<ExamDto> createExam(@Valid @RequestBody CreateExamRequest createExamRequest) throws SubjectNotFoundException {
        ExamDto exam = examService.createExam(createExamRequest);
        return ResponseEntity.ok().body(exam);
    }

    @GetMapping("/{examId}")
    public ResponseEntity<ExamDto> getExamById(@PathVariable(value = "examId") long examId) throws ExamNotFoundException {
        ExamDto exam = examService.findExamById(examId);
        return ResponseEntity.ok().body(exam);
    }

    @GetMapping
    public ResponseEntity<GetAllExamsResponse> getAllExams() {
        List<ExamDto> exams = examService.findAllExams();
        GetAllExamsResponse getAllExamsResponse = new GetAllExamsResponse(exams);
        return ResponseEntity.ok().body(getAllExamsResponse);
    }

    @DeleteMapping("/{examId}")
    public ResponseEntity<String> deleteExam(@PathVariable long examId) throws ExamNotFoundException {
        String message = "Successfully deleted exam with ID: " + String.valueOf(examId);
        examService.deleteExam(examId);
        return ResponseEntity.ok().body(message);
    }
}
