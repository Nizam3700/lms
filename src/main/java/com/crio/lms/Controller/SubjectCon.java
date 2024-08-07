package com.crio.lms.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crio.lms.entity.Subject;
import com.crio.lms.service.SubjectService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/subject")
public class SubjectCon {

    @Autowired
    private SubjectService subjectService;
    
    @GetMapping
    public List<Subject> getAllsubjects() {
        return subjectService.getAllSubjects();
    }

    @PostMapping
    public ResponseEntity<Subject> postMethodName(@RequestBody Subject subject) {
        //TODO: process POST request
        Subject AddSubject = subjectService.saveSubject(subject);
        return new ResponseEntity<>(AddSubject, HttpStatus.CREATED);
    }
    
    
}
