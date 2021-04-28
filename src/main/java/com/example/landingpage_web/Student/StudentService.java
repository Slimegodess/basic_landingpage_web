package com.example.landingpage_web.Student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudents() {
        return List.of(
                new Student(
                        1L,
                        "Willma",
                        "Willma.Kuss@vondir.com",
                        LocalDate.of(2000, Month.JULY, 5),
                        21
                )
        );
    }
}
