package com.crio.lms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crio.lms.entity.Student;
import com.crio.lms.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentCon {
    
    @Autowired
    StudentService studentser;

    @PostMapping
    public Student SaveStudent(RequestBody Student){
        return studentser.SaveStudent();
    }
}
