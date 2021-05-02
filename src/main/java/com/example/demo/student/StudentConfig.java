package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student mario = new Student(
                "Mario",
                "mario@nintendo.com",
                LocalDate.of(1985, Month.SEPTEMBER, 5)
            );
            Student pikachu = new Student(
                "Pikachu",
                "pikachu@nintendo.com",
                LocalDate.of(1996, Month.OCTOBER, 15)
            );

            repository.saveAll(
                List.of(mario, pikachu)
            );
        };
    }
}
