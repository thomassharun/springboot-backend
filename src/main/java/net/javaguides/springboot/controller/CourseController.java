package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Course;
import net.javaguides.springboot.repository.CourseRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class CourseController {

	@Autowired
	private CourseRepository courseRepository;

	// get all Courses
	@GetMapping("/course")
	public List<Course> getAllCourses() {
		System.out.println(courseRepository.findAll());
		return courseRepository.findAll();
	}

	// create Course rest api
	@PostMapping("/course")
	public Course createCourse(@RequestBody Course Course) {
		return courseRepository.save(Course);
	}

	// get Course by id rest api
	@GetMapping("/course/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
		Course Course = courseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Course not exist with id :" + id));
		return ResponseEntity.ok(Course);
	}

	// update Course rest api
	@PutMapping("/course/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course CourseDetails) {
		Course Course = courseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Course not exist with id :" + id));

		Course.setName(CourseDetails.getName());
		Course.setDeptHead(CourseDetails.getDeptHead());
		Course.setDeptCode(CourseDetails.getDeptCode());
		Course.setDepartment(CourseDetails.getDepartment());

		Course updatedCourse = courseRepository.save(Course);
		return ResponseEntity.ok(updatedCourse);
	}

	// delete Course rest api
	@DeleteMapping("/course/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCourse(@PathVariable Long id) {
		Course Course = courseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Course not exist with id :" + id));

		courseRepository.delete(Course);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	

}
