package com.crio.LearningNavigator.repositoryServices;

import java.util.List;

import com.crio.LearningNavigator.dto.SubjectDto;
import com.crio.LearningNavigator.exceptions.SubjectNotFoundException;

public interface SubjectRepositoryService {

    SubjectDto createSubject(String subjectName);

    SubjectDto findSubjectById(long subjectId) throws SubjectNotFoundException;

    List<SubjectDto> findAllSubjects();

    void deleteSubject(long subjectId) throws SubjectNotFoundException;
}
