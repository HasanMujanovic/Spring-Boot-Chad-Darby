package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    List<Student> theStudents = new ArrayList<>();
    // define @PostConstruct to load the student data only once!
    @PostConstruct
    public void loadData(){
        theStudents.add(new Student("Porrima","Pate;"));
        theStudents.add(new Student("Mario","Rossi;"));
        theStudents.add(new Student("Marry","Smith;"));
    }

    // define endpoint for "/students" = return list of students

    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    // define endpoint for "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        // just index into the list. keeping it simple for now

        //check the studentId against list size
        if (studentId >= theStudents.size() || studentId < 0){
            throw new StudentNotFoundException("Student id not found - " +
                    studentId);
        }
        return theStudents.get(studentId);
    }
}

