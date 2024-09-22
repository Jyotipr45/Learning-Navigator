package com.crio.LearningNavigator.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.LearningNavigator.dto.SubjectDto;
import com.crio.LearningNavigator.exceptions.SubjectNotFoundException;
import com.crio.LearningNavigator.exchanges.CreateSubjectRequest;
import com.crio.LearningNavigator.repositoryServices.SubjectRepositoryService;
import com.crio.LearningNavigator.services.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepositoryService subjectRepositoryService;

    @Override
    public SubjectDto createSubject(CreateSubjectRequest createSubjectRequest) {
        String subjectName = createSubjectRequest.getSubjectName();
        SubjectDto subject = subjectRepositoryService.createSubject(subjectName);
        return subject;
    }

    @Override
    public SubjectDto findSubjectById(long subjectId) throws SubjectNotFoundException {
        SubjectDto subject = subjectRepositoryService.findSubjectById(subjectId);
        return subject;
    }

    @Override
    public List<SubjectDto> findAllSubjects() {
        List<SubjectDto> subjects = subjectRepositoryService.findAllSubjects();
        return subjects;
    }

    @Override
    public void deleteSubject(long subjectId) throws SubjectNotFoundException {
       subjectRepositoryService.deleteSubject(subjectId);
    }
    
}
