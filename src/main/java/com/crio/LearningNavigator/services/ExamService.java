package com.crio.LearningNavigator.services;

import java.util.List;

import com.crio.LearningNavigator.dto.ExamDto;
import com.crio.LearningNavigator.exceptions.ExamNotFoundException;
import com.crio.LearningNavigator.exceptions.SubjectNotFoundException;
import com.crio.LearningNavigator.exchanges.CreateExamRequest;

public interface ExamService {
    
    ExamDto createExam(CreateExamRequest createExamRequest) throws SubjectNotFoundException;

    ExamDto findExamById(long examId) throws ExamNotFoundException;

    List<ExamDto> findAllExams();

    void deleteExam(long examId) throws ExamNotFoundException;
    
}
