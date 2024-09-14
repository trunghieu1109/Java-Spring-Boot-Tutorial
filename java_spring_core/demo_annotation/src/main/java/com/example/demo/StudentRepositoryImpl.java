package com.example.demo;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    /**
     * Interact with database and get sample student. Just pseudo mode
     * 
     * @return
     */
    @Override
    public Student getSampleStudent() {
        return new Student();
    }
}
