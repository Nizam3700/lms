package com.crio.lms.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crio.lms.entity.Student;
import com.crio.lms.service.StudentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/student")
public class StudentCon {
    
    @Autowired
    private StudentService studentservice;

    @PostMapping
    public Student SaveStudent(@RequestBody Student student){
        return studentservice.SaveStudent(student);
    }

    @GetMapping
    public List<Student> getAllstudents() {
        return studentservice.getAllStudents();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
        Optional<Student> updatedStudent = studentservice.updateStudent(id, student.getSubjects(), student.getExams());
        return updatedStudent.map(ResponseEntity::ok)
                             .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deregisterStudent(@PathVariable long id){
        Optional<Student> deletStudents = studentservice.DeregisterStudent(id);
        if(deletStudents.isPresent()){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
