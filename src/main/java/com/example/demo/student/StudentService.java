package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
    /*
        @Service is a @Component Spring annotation, though Service is instead used here
        for semantics to more easily identify that this Spring Component is a Service class.
    */

public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository
            .findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException(
                "student with id " + studentId + "does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    /*
        Transactional annotation is used here as the set values using the Entity's get and set values
        enter a managed state and are provided to the database using JPA in this fashion.

        The transactional annotation itself defines the scope of a single database transaction. The database transaction happens inside the scope of apersistence context.

        The persistence context is in JPA the EntityManager, implemented internally using an
        Hibernate Session (when using Hibernate as the persistence provider).

        The persistence context is just a synchronizer object that tracks the state of a
        limited set of Java objects and makes sure that changes on those objects are eventually
        persisted back into the database.

        From: https://dzone.com/articles/how-does-spring-transactional

        CRUD methods on the repository are transactional by default.
     */
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
            .orElseThrow(() -> new IllegalStateException(
                "student with id " + studentId + "does not exist")
            );
        /*
            If the param provided name variable is not null, has a length greather than 0 and
            the Object's name (checked by using the student entity's getter method aren't the same,
            use the entity's setter method to set the value to the param variable provided
         */
        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {

            Optional<Student> studentOptional = studentRepository
                .findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email already exists");
            }
            student.setEmail(email);
        }
    }
}
