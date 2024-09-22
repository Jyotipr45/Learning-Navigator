package com.crio.LearningNavigator.exceptions;

import java.io.IOException;

public class SubjectNotEnrolledException extends IOException {
    
    public SubjectNotEnrolledException() {

    } 

    public SubjectNotEnrolledException(String message) {
        super(message);
    }
    
}
