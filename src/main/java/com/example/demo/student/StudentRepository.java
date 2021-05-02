package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
/*  Responsible for data access.
    To research generic further.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

}
