package net.javaguides.springboot.mappers;

import org.springframework.stereotype.Component;

import net.javaguides.springboot.model.Course;
import net.javaguides.springboot.model.Student;
import net.javaguides.springboot.model.StudentDetails;


@Component
public class StudentDetailsMapper {
	
	
	public StudentDetails createStudentDetails(Student st, Course c){
		StudentDetails sd = new StudentDetails();
		Course crs = new Course();
		
		sd.setId(st.getId()); 
		sd.setFirstName(st.getFirstName());
		sd.setEmailId(st.getEmailId());
		sd.setLastName(st.getLastName());
		sd.setCourseName(c.getName());
		sd.setGpa(st.getGpa());
		crs.setDepartment(c.getDepartment());
		crs.setDeptCode(c.getDeptCode());
		crs.setDeptHead(c.getDeptHead());
		crs.setName(c.getName());
		crs.setId(c.getId());
		crs.setSubjects(c.getSubjects());
		sd.setCourse(crs);
		
		return sd;
	}
}
