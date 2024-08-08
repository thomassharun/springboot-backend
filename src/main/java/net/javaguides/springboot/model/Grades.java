package net.javaguides.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "grades")
public class Grades {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "stdid")
	private long stdid;

	@Column(name = "s1")
	private long s1;

	@Column(name = "s2")
	private long s2;

	@Column(name = "s3")
	private long s3;
	
	@Column(name = "s4")
	private long s4;
	
	@Column(name = "s5")
	private long s5;
	
	@Column(name = "cr1")
	private long cr1;

	@Column(name = "cr2")
	private long cr2;

	@Column(name = "cr3")
	private long cr3;
	
	@Column(name = "cr4")
	private long cr4;
	
	@Column(name = "cr5")
	private long cr5;

	public Grades() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getStdid() {
		return stdid;
	}

	public void setStdid(long stdid) {
		this.stdid = stdid;
	}

	public long getS1() {
		return s1;
	}

	public void setS1(long s1) {
		this.s1 = s1;
	}

	public long getS2() {
		return s2;
	}

	public void setS2(long s2) {
		this.s2 = s2;
	}

	public long getS3() {
		return s3;
	}

	public void setS3(long s3) {
		this.s3 = s3;
	}

	public long getS4() {
		return s4;
	}

	public void setS4(long s4) {
		this.s4 = s4;
	}

	public long getS5() {
		return s5;
	}

	public void setS5(long s5) {
		this.s5 = s5;
	}

	public long getCr1() {
		return cr1;
	}

	public void setCr1(long cr1) {
		this.cr1 = cr1;
	}

	public long getCr2() {
		return cr2;
	}

	public void setCr2(long cr2) {
		this.cr2 = cr2;
	}

	public long getCr3() {
		return cr3;
	}

	public void setCr3(long cr3) {
		this.cr3 = cr3;
	}

	public long getCr4() {
		return cr4;
	}

	public void setCr4(long cr4) {
		this.cr4 = cr4;
	}

	public long getCr5() {
		return cr5;
	}

	public void setCr5(long cr5) {
		this.cr5 = cr5;
	}

	public Grades(long id, long stdid, long s1, long s2, long s3, long s4, long s5, long cr1, long cr2,
			long cr3, long cr4, long cr5) {
		super();
		this.id = id;
		this.stdid = stdid;
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
		this.s4 = s4;
		this.s5 = s5;
		this.cr1 = cr1;
		this.cr2 = cr2;
		this.cr3 = cr3;
		this.cr4 = cr4;
		this.cr5 = cr5;
	}

	
}
