package com.crio.LearningNavigator.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.LearningNavigator.dto.ExamDto;
import com.crio.LearningNavigator.exceptions.ExamNotFoundException;
import com.crio.LearningNavigator.exceptions.SubjectNotFoundException;
import com.crio.LearningNavigator.exchanges.CreateExamRequest;
import com.crio.LearningNavigator.repositoryServices.ExamRepositoryService;
import com.crio.LearningNavigator.services.ExamService;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamRepositoryService examRepositoryService;

    @Override
    public ExamDto createExam(CreateExamRequest createExamRequest) throws SubjectNotFoundException {
        long subjectId = createExamRequest.getSubjectId();
        ExamDto exam = examRepositoryService.createExam(subjectId);
        return exam;
    }

    @Override
    public ExamDto findExamById(long examId) throws ExamNotFoundException {
        ExamDto exam = examRepositoryService.findExamById(examId);
        return exam;
    }

    @Override
    public List<ExamDto> findAllExams() {
        List<ExamDto> exams = examRepositoryService.findAllExams();
        return exams;
    }

    @Override
    public void deleteExam(long examId) throws ExamNotFoundException {
        examRepositoryService.deleteExam(examId);
    }
    
}
