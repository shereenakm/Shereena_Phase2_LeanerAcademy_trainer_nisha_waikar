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
public class Subjects {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@PrimaryKeyJoinColumn
	private int  subjectid;
	
	@Column
	private String subjectname;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn
	private Classes classes;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn
	private Teachers teacher;
	
	public Subjects() {
		
	}
	
	public Teachers getTeacher() {
		return teacher;
	}

	public void setTeacher(Teachers teacher) {
		this.teacher = teacher;
	}

	public Subjects( String subjectname) {
		super();
		this.subjectname = subjectname;
		}


	public Classes getClasses() {
		return classes;
	}


	public void setClasses(Classes classes) {
		this.classes = classes;
	}



	public String getSubjectname() {
		return subjectname;
	}


	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}


	public int getSubjectid() {
		return subjectid;
	}


	public void setSubjectid(int subjectid) {
		this.subjectid = subjectid;
	}


	
}
