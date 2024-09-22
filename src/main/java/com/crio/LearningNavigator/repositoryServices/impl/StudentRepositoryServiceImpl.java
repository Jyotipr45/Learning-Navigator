package com.crio.LearningNavigator.repositoryServices.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.LearningNavigator.dto.StudentDto;
import com.crio.LearningNavigator.exceptions.ExamNotFoundException;
import com.crio.LearningNavigator.exceptions.StudentNotFoundException;
import com.crio.LearningNavigator.exceptions.SubjectNotEnrolledException;
import com.crio.LearningNavigator.exceptions.SubjectNotFoundException;
import com.crio.LearningNavigator.entities.ExamEntity;
import com.crio.LearningNavigator.entities.StudentEntity;
import com.crio.LearningNavigator.entities.SubjectEntity;
import com.crio.LearningNavigator.repositories.ExamRepository;
import com.crio.LearningNavigator.repositories.StudentRepository;
import com.crio.LearningNavigator.repositories.SubjectRepository;
import com.crio.LearningNavigator.repositoryServices.StudentRepositoryService;

import jakarta.inject.Provider;

@Service
public class StudentRepositoryServiceImpl implements StudentRepositoryService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private Provider<ModelMapper> modelMapperProvider;

    @Override
    public StudentDto createStudent(String studentName) {
        ModelMapper modelMapper = modelMapperProvider.get();
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(studentName);
        StudentDto student = modelMapper.map(studentRepository.save(studentEntity), StudentDto.class);
        return student;
    }

    @Override
    public StudentDto findStudentById(long studentId) throws StudentNotFoundException {
        ModelMapper modelMapper = modelMapperProvider.get();
        Optional<StudentEntity> maybeStudentEntity = studentRepository.findById(studentId);
        
        if(maybeStudentEntity.isPresent()) {
            StudentEntity studentEntity = maybeStudentEntity.get();
            // System.out.println("Enrolled Subjects: " + studentEntity.getEnrolledSubjects());
            StudentDto student = modelMapper.map(studentEntity, StudentDto.class);
            return student;
        }
        else {
            String message = "Could not find student with ID: " + String.valueOf(studentId);
            throw new StudentNotFoundException(message);
        }
    }

    @Override
    public StudentDto enrollStudentInSubject(long studentId, long subjectId)
            throws StudentNotFoundException, SubjectNotFoundException {
        ModelMapper modelMapper = modelMapperProvider.get();
        String studentNotFoundMessage = "Could not find student with ID: " + String.valueOf(studentId);
        String subjectNotFoundMessage = "Could not find subject with ID: " + String.valueOf(subjectId);

        StudentEntity studentEntity = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException(studentNotFoundMessage));
        SubjectEntity subjectEntity = subjectRepository.findById(subjectId).orElseThrow(() -> new SubjectNotFoundException(subjectNotFoundMessage));

        Set<SubjectEntity> enrolledSubjects = studentEntity.getEnrolledSubjects();
        enrolledSubjects.add(subjectEntity);

        StudentDto student = modelMapper.map(studentRepository.save(studentEntity), StudentDto.class);
        
        return student;
    }

    @Override
    public StudentDto registerStudentForExam(long studentId, long examId)
            throws StudentNotFoundException, ExamNotFoundException, SubjectNotEnrolledException {
        ModelMapper modelMapper = modelMapperProvider.get();
        String studentNotFoundMessage = "Could not find student with ID: " + String.valueOf(studentId);
        String examNotFoundMessage = "Could not find exam with ID: " + String.valueOf(examId);

        StudentEntity studentEntity = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException(studentNotFoundMessage));
        ExamEntity examEntity = examRepository.findById(examId).orElseThrow(() -> new ExamNotFoundException(examNotFoundMessage));
        SubjectEntity subjectEntity = examEntity.getSubjectEntity();

        String subjectNotEnrolledMessage = "Student has not enrolled in subject with ID: " + String.valueOf(subjectEntity.getId());

        if(isSubjectEnrolled(studentEntity, subjectEntity)) {
            Set<ExamEntity> registeredExams = studentEntity.getRegisteredExams();
            registeredExams.add(examEntity);
            StudentDto student = modelMapper.map(studentRepository.save(studentEntity), StudentDto.class);
            return student;
        }
        else {
            throw new SubjectNotEnrolledException(subjectNotEnrolledMessage);
        }
    }

    @Override
    public List<StudentDto> findAllStudents() {
        List<StudentEntity> studentEntities = studentRepository.findAll();
        List<StudentDto> students = mapToStudentList(studentEntities);
        return students;
    }

    @Override
    public void deleteStudent(long studentId) throws StudentNotFoundException {
        String message = "Could not find student with ID: " + String.valueOf(studentId);
        StudentEntity studentEntity = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException(message));
        studentRepository.delete(studentEntity);
    }

    private List<StudentDto> mapToStudentList(List<StudentEntity> studentEntities) {
        List<StudentDto> students = new ArrayList<>();
        ModelMapper modelMapper = modelMapperProvider.get();

        for(StudentEntity studentEntity : studentEntities) {
            StudentDto student = modelMapper.map(studentEntity, StudentDto.class);
            students.add(student);
        }

        return students;
    }

    private boolean isSubjectEnrolled(StudentEntity studentEntity, SubjectEntity subjectEntity) {
        Set<SubjectEntity> enrolledSubjects = studentEntity.getEnrolledSubjects();

        if(enrolledSubjects.contains(subjectEntity))
            return true;
        return false;
    }
    
}
