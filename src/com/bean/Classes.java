package com.bean;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "classes")
public class Classes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@PrimaryKeyJoinColumn
	private int classid;
	
	@Column
	private String classname;
	
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn
	private List<Student> student;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn
	private List<Teachers> teacher;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn
	private List<Subjects> subjectList;

	
	public List<Student> getStudent() {
		return student;
	}


	public void setStudent(List<Student> student) {
		this.student = student;
	}


	public List<Teachers> getTeacher() {
		return teacher;
	}


	public void setTeacher(List<Teachers> teacher) {
		this.teacher = teacher;
	}


	public List<Subjects> getSubjectList() {
		return subjectList;
	}


	public void setSubjectList(List<Subjects> subjectList) {
		this.subjectList = subjectList;
	}


	
public Classes(){
	
}


public Classes(String classname) {
	super();
	this.classname = classname;
}


public int getClassid() {
	return classid;
}


public void setClassid(int classid) {
	this.classid = classid;
}


public String getClassname() {
	return classname;
}


public void setClassname(String classname) {
	this.classname = classname;
}


}

