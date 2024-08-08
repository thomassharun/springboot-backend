package net.javaguides.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "dept_head")
	private String deptHead;

	@Column(name = "dept_code")
	private String deptCode;

	@Column(name = "department")
	private String department;
	
	@Column(name = "subjects")
	private String subjects;

	public Course() {

	}

	public Course(String name, String deptHead, String deptCode, String department) {
		super();
		this.name = name;
		this.deptHead = deptHead;
		this.deptCode = deptCode;
		this.department = department;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDeptHead() {
		return deptHead;
	}

	public void setDeptHead(String deptHead) {
		this.deptHead = deptHead;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getSubjects() {
		return subjects;
	}

	public void setSubjects(String sub) {
		this.subjects = sub;
	}
}
