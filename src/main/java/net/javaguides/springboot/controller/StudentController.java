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
import net.javaguides.springboot.mappers.StudentDetailsMapper;
import net.javaguides.springboot.model.Course;
import net.javaguides.springboot.model.Grades;
import net.javaguides.springboot.model.Student;
import net.javaguides.springboot.model.StudentDetails;
import net.javaguides.springboot.repository.CourseRepository;
import net.javaguides.springboot.repository.GradesRepository;
import net.javaguides.springboot.repository.GradesRepository;
import net.javaguides.springboot.repository.StudentRepository;
import net.javaguides.springboot.utility.Commons;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private GradesRepository grdRepo;

	@Autowired
	private StudentDetailsMapper sdm;

	@Autowired
	private CourseRepository cr;

	// get all Students
	@GetMapping("/student")
	public List<Student> getAllStudents() {
		System.out.println(studentRepository.findAll());
		return studentRepository.findAll();
	}

	// create Student rest api
	@PostMapping("/student")
	public Student createStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}

	// get Student by id rest api
	@GetMapping("/student/{id}")
	public ResponseEntity<StudentDetails> getStudentById(@PathVariable Long id) {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));

		Course course = cr.findByName(student.getCourse())
				.orElseThrow(() -> new ResourceNotFoundException("Course not exist with name :" + student.getCourse()));
		StudentDetails sd = sdm.createStudentDetails(student, course);
		return ResponseEntity.ok(sd);
	}

	// get Student by id rest api
	@GetMapping("/studentById/{id}")
	public ResponseEntity<Student> getStudentById1(@PathVariable Long id) {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));
		// StudentDetails sd = sdm.createStudentDetails(student, course);
		return ResponseEntity.ok(student);
	}

	// update Student rest api

	@PutMapping("/student/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));

		student.setFirstName(studentDetails.getFirstName());
		student.setLastName(studentDetails.getLastName());
		student.setEmailId(studentDetails.getEmailId());
		student.setCourse(studentDetails.getCourse());
		Student updatedStudent = studentRepository.save(student);
		return ResponseEntity.ok(updatedStudent);
	}

	// delete Student rest api
	@DeleteMapping("/student/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Long id) {
		Student Student = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));

		studentRepository.delete(Student);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	// delete Student rest api
	@PostMapping("/grades")
	public ResponseEntity<Map<String, Boolean>> gradeUpdate(@RequestBody Grades grades) {
		
		Grades grd = grdRepo.save(grades);
		
		Student student = studentRepository.findById(grades.getStdid())
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + grades.getStdid()));
		double gpa = Commons.calculateGPA(grd);
		
		// Convert to two decimal places using String.format()
        String formattedValue = String.format("%.2f", gpa);
        System.out.println("Formatted value: " + formattedValue);

        // Convert back to double if needed
        double roundedValue = Double.parseDouble(formattedValue);
        System.out.println("Rounded value: " + roundedValue);
        
		student.setGpa(roundedValue);
		Student student1 = studentRepository.save(student);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Updated", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
