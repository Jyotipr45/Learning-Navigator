package com.crio.LearningNavigator.exchanges;

import java.util.List;

import com.crio.LearningNavigator.dto.SubjectDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetAllSubjectsResponse {
    private List<SubjectDto> subjects;
}
