package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Grades;

@Repository
public interface GradesRepository extends JpaRepository<Grades, Long>{

	//Optional<Student> findByStdid();

}
