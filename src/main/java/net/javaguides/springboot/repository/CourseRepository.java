package net.javaguides.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Course;
import net.javaguides.springboot.model.Student;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

	Optional<Course> findByName(String name);
}
