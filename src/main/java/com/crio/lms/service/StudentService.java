package com.crio.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.lms.entity.Student;
import com.crio.lms.repository.StudentRepository;

@Service
public class StudentService {
    
    @Autowired
    StudentRepository studentRepo;

    public Student SaveStudent(){
        return studentRepo.save(SaveStudent());
    }

}
