package com.crio.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crio.lms.entity.Exam;

public interface ExamRepository extends JpaRepository<Exam,Long>{
    
}
