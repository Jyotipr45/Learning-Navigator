package com.crio.LearningNavigator.services;

import java.util.List;

import com.crio.LearningNavigator.dto.SubjectDto;
import com.crio.LearningNavigator.exceptions.SubjectNotFoundException;
import com.crio.LearningNavigator.exchanges.CreateSubjectRequest;

public interface SubjectService {

    SubjectDto createSubject(CreateSubjectRequest createSubjectRequest);

    SubjectDto findSubjectById(long subjectId) throws SubjectNotFoundException;

    List<SubjectDto> findAllSubjects();

    void deleteSubject(long subjectId) throws SubjectNotFoundException;

}
