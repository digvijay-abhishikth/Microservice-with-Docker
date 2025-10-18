package com.Ignitia.studentService.repository;

import com.Ignitia.studentService.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Object> getStById(Long id);
}
