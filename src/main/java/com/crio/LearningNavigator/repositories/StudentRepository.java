package com.crio.LearningNavigator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crio.LearningNavigator.entities.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    
}
