package com.example.landingpage_web.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required=false) String name,
            @RequestParam(required=false) String email) {
        studentService.updateStudent(studentId, name, email);
    }

    @PostMapping(path ="/addstudent")
    public String addNewStudent(@ModelAttribute Student student, Model model){
        studentService.addNewStudent(student);
        model.addAttribute("student",student);
        return "studentresult";
    }

    @GetMapping(path ="/addstudent")
    public String addNewStudent(Model model){
        model.addAttribute("student", new Student());
        return "addstudent";
    }

    @GetMapping(path ="/liststudents")
    public String studentsTable(Model model){
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "studentstable";
    }
}
