package com.example.studentmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    
     @GetMapping("/allstudents")
     public  List<Student> getAllStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        System.out.println("in StudentController");
        model.addAttribute("students", students);
        return students;
    }

    @PostMapping("/savestudent")
    public Student saveStudent(@ModelAttribute Student student) {
        
        return studentService.saveStudent(student);
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "ok deleted";
    }
}
