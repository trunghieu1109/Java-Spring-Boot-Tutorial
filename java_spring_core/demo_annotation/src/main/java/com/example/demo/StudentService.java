package com.example.demo;

import com.example.demo.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    /**
     * Get a random student from database via repository
     * 
     * @return Student
     */
    public Student getRandomStudent() {
        return studentRepository.getSampleStudent();
    }
}