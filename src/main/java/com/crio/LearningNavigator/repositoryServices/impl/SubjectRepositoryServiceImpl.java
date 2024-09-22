package com.crio.LearningNavigator.repositoryServices.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.LearningNavigator.dto.SubjectDto;
import com.crio.LearningNavigator.exceptions.SubjectNotFoundException;
import com.crio.LearningNavigator.entities.SubjectEntity;
import com.crio.LearningNavigator.repositories.SubjectRepository;
import com.crio.LearningNavigator.repositoryServices.SubjectRepositoryService;

import jakarta.inject.Provider;

@Service
public class SubjectRepositoryServiceImpl implements SubjectRepositoryService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private Provider<ModelMapper> modelMapperProvider;

    @Override
    public SubjectDto createSubject(String subjectName) {
        ModelMapper modelMapper = modelMapperProvider.get();
        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setName(subjectName);

        SubjectDto subject = modelMapper.map(subjectRepository.save(subjectEntity), SubjectDto.class);
        return subject;
    }

    @Override
    public SubjectDto findSubjectById(long subjectId) throws SubjectNotFoundException {
        String message = "Could not find subject with ID: " + String.valueOf(subjectId);
        ModelMapper modelMapper = modelMapperProvider.get();

        SubjectEntity subjectEntity = subjectRepository.findById(subjectId).orElseThrow(() -> new SubjectNotFoundException(message));
        SubjectDto subject = modelMapper.map(subjectEntity, SubjectDto.class);
        return subject;
    }

    @Override
    public List<SubjectDto> findAllSubjects() {
        List<SubjectEntity> subjectEntities = subjectRepository.findAll();
        List<SubjectDto> subjects = mapToSubjectList(subjectEntities);
        return subjects;
    }

    @Override
    public void deleteSubject(long subjectId) throws SubjectNotFoundException {
        String message = "Could not find subject with ID: " + String.valueOf(subjectId);
        SubjectEntity subjectEntity = subjectRepository.findById(subjectId).orElseThrow(() -> new SubjectNotFoundException(message));
        subjectRepository.delete(subjectEntity);
    }

    private List<SubjectDto> mapToSubjectList(List<SubjectEntity> subjectEntities) {
        List<SubjectDto> subjects = new ArrayList<>();
        ModelMapper modelMapper = modelMapperProvider.get();

        for(SubjectEntity subjectEntity : subjectEntities) {
            SubjectDto subject = modelMapper.map(subjectEntity, SubjectDto.class);
            subjects.add(subject);
        }
        
        return subjects;
    }
    
}
