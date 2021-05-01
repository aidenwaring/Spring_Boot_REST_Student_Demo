package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
    /*
    @Service is a @Component Spring annotation, though Service is instead used here
    for semantics to more easily identify that this Spring Component is a Service class.
    */

public class StudentService {
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
