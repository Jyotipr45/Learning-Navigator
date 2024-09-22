package com.crio.LearningNavigator.repositoryServices;

import java.util.List;

import com.crio.LearningNavigator.dto.ExamDto;
import com.crio.LearningNavigator.exceptions.ExamNotFoundException;
import com.crio.LearningNavigator.exceptions.SubjectNotFoundException;

public interface ExamRepositoryService {
    ExamDto createExam(long subjectId) throws SubjectNotFoundException;

    ExamDto findExamById(long examId) throws ExamNotFoundException;

    List<ExamDto> findAllExams();

    void deleteExam(long examId) throws ExamNotFoundException;
}
