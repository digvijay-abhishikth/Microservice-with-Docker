package com.Ignitia.courseService.repository;

import com.Ignitia.courseService.entity.Course;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
