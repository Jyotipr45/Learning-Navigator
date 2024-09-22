package com.crio.LearningNavigator.repositoryServices.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.LearningNavigator.dto.ExamDto;
import com.crio.LearningNavigator.exceptions.ExamNotFoundException;
import com.crio.LearningNavigator.exceptions.SubjectNotFoundException;
import com.crio.LearningNavigator.entities.ExamEntity;
import com.crio.LearningNavigator.entities.SubjectEntity;
import com.crio.LearningNavigator.repositories.ExamRepository;
import com.crio.LearningNavigator.repositories.SubjectRepository;
import com.crio.LearningNavigator.repositoryServices.ExamRepositoryService;

import jakarta.inject.Provider;

@Service
public class ExamRepositoryServiceImpl implements ExamRepositoryService {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private Provider<ModelMapper> modelMapperProvider;

    @Override
    public ExamDto createExam(long subjectId) throws SubjectNotFoundException {
        String message = "Could not find subject with ID: " + String.valueOf(subjectId);
        ModelMapper modelMapper = modelMapperProvider.get();

        ExamEntity examEntity = new ExamEntity();
        SubjectEntity subjectEntity = subjectRepository.findById(subjectId).orElseThrow(() -> new SubjectNotFoundException(message));

        examEntity.setSubjectEntity(subjectEntity);
        ExamDto exam = modelMapper.map(examRepository.save(examEntity), ExamDto.class);
        return exam;
    }

    @Override
    public ExamDto findExamById(long examId) throws ExamNotFoundException {
        String message = "Could not find exam with ID: " + String.valueOf(examId);
        ModelMapper modelMapper = modelMapperProvider.get();
        ExamEntity examEntity = examRepository.findById(examId).orElseThrow(() -> new ExamNotFoundException(message));
        ExamDto exam = modelMapper.map(examEntity, ExamDto.class);
        return exam;
    }

    @Override
    public List<ExamDto> findAllExams() {
        List<ExamEntity> examEntities = examRepository.findAll();
        List<ExamDto> exams = mapToExamList(examEntities);
        return exams;
    }

    @Override
    public void deleteExam(long examId) throws ExamNotFoundException {
        String message = "Could not find exam with ID: " + String.valueOf(examId);
        ExamEntity examEntity = examRepository.findById(examId).orElseThrow(() -> new ExamNotFoundException(message));
        examRepository.delete(examEntity);
    }
    
    private List<ExamDto> mapToExamList(List<ExamEntity> examEntities) {
        List<ExamDto> exams = new ArrayList<>();
        ModelMapper modelMapper = modelMapperProvider.get();

        for(ExamEntity examEntity : examEntities) {
            ExamDto exam = modelMapper.map(examEntity, ExamDto.class);
            exams.add(exam);
        }
        
        return exams;
    }
}
