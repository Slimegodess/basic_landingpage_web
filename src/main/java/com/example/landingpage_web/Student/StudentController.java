package com.example.landingpage_web.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
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

    @PostMapping("/addstudent")
    public String studentSubmit(@ModelAttribute Student student, Model model){
        studentService.addNewStudent(student);
        model.addAttribute("student",student);
        return "studentresult";
    }

    @GetMapping("/liststudents")
    public String studentsTable(Model model){
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "studentstable";
    }

}
