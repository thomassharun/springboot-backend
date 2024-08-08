package net.javaguides.springboot.model;

public class StudentDetails {
	
	
	private long id;
	
	private String firstName;

	private String lastName;
	
	private String emailId;
	
	private String courseName;
	
	private Course course;
	private double gpa;
	
	public StudentDetails() {
		
	}
	
	public StudentDetails(long id, String firstName, String lastName, String emailId, Course course, double gpa) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.course = course;
		this.gpa = gpa;
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}
	
	public double getGpa() {
		return gpa;
	}


	public void setGpa(double gpa) {
		this.gpa = gpa;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}

}
