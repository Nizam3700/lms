package com.crio.lms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.crio.lms.entity.Exam;
import com.crio.lms.entity.Student;
import com.crio.lms.entity.Subject;
import com.crio.lms.repository.StudentRepository;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepo;

    // PostMapping  
    public Student SaveStudent(Student student){
        return studentRepo.save(student);
    }

    // GetMapping 
    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    // PutMapping
    public Optional<Student> updateStudent(long id, List<Subject> subjects, List<Exam> exams) {
        Optional<Student> studentOptional = studentRepo.findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setSubjects(subjects);
            student.setExams(exams);
            return Optional.of(studentRepo.save(student));
        }
        return Optional.empty();
    }  

    // DeleteMapping
    public Optional<Student> DeregisterStudent(Long id){
        Optional<Student> deregister = studentRepo.findById(id);
        deregister.ifPresent(studentRepo::delete);
        return deregister;
    }

}
