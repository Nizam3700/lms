package com.crio.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.lms.entity.Subject;
import com.crio.lms.repository.SubjectRepository;

@Service
public class SubjectService {
    
    @Autowired
    private SubjectRepository subjectRepo;

    // @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectRepo.findAll();
    }

    //@putmapping
    public Optional<Subject> getSubjectById(Long id) {
        return subjectRepo.findById(id);
    }

    //@postMapping
    public Subject saveSubject(Subject subject) {
        return subjectRepo.save(subject);
    }

    //@DeleteMapping
    public Optional<Subject> updateSubject(Long id, Subject subject) {
        Optional<Subject> subjectOptional = subjectRepo.findById(id);
    }
}
