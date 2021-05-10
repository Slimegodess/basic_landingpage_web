package com.example.landingpage_web.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository) {
        return args -> {
            Student Paul = new Student(
                    "Paul",
                    "Paul-Penny@gmail.com",
                    LocalDate.of(2000,JANUARY,5)
            );

            Student Oke = new Student(
                    "Oke",
                    "OkeOkeOke@gmail.com",
                    LocalDate.of(2002,FEBRUARY,7)
            );

            Student Marrie = new Student(
                    "Marrie",
                    "Marrie_Miller@htw.de",
                    LocalDate.of(1999,JUNE,9)
            );

            repository.saveAll(List.of(Marrie, Oke, Paul));
        };
    }
}
