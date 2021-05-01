package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    @GetMapping
    public List<Student> getStudents() {
        return List.of(
            new Student(
                1L,
                "Mario",
                "mario@nintendo.com",
                LocalDate.of(1985, Month.SEPTEMBER, 5), 35
            )
        );
    }

}
