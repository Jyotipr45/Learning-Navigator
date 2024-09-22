package com.crio.LearningNavigator.exchanges;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterStudentRequest {

    @NotEmpty
    private String studentName;
}
