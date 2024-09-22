package com.crio.LearningNavigator.exceptions;

import java.io.IOException;

public class StudentNotFoundException extends IOException{

    public StudentNotFoundException() {

    }

    public StudentNotFoundException(String message) {
        super(message);
    }
}
