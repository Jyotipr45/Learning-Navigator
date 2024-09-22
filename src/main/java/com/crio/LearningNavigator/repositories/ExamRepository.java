package com.crio.LearningNavigator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crio.LearningNavigator.entities.ExamEntity;

public interface ExamRepository extends JpaRepository<ExamEntity, Long> {
    
}
