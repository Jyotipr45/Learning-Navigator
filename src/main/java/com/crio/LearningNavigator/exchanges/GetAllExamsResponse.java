package com.crio.LearningNavigator.exchanges;

import java.util.List;

import com.crio.LearningNavigator.dto.ExamDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetAllExamsResponse {
    private List<ExamDto> exams;
}
