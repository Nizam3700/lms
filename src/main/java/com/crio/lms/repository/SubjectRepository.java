package com.crio.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crio.lms.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject,Long>{
    
}
