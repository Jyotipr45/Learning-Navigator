package com.crio.LearningNavigator.exchanges;

import java.util.List;

import com.crio.LearningNavigator.dto.StudentDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetAllStudentsResponse {
    private List<StudentDto> students;
}
