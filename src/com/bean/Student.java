package com.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@PrimaryKeyJoinColumn
	private int studentId;
	
	@Column
	private String student_name;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn
	private Classes classes;

	
	
	public Student() {
	
}

public Student( String student_name, Classes classes) {
	super();

	this.student_name = student_name;
	this.classes = classes;
}

public int getStudentId() {
	return studentId;
}
public void setStudentId(int studentId) {
	this.studentId = studentId;
}
public String getStudent_name() {
	return student_name;
}
public void setStudent_name(String student_name) {
	this.student_name = student_name;
}


public Classes getClasses() {
	return classes;
}
public void setClasses(Classes classes) {
	this.classes = classes;
}
@Override
public String toString() {
	return "Student [studentId=" + studentId + ", student_name=" + student_name +  ", classes="+ classes + "]";
}

}
