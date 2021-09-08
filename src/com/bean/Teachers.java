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
@Table
public class Teachers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@PrimaryKeyJoinColumn
	private int TeacherId;
	
	@Column
	private String Teachername;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn
	private List<Classes> classesList ;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn
	private List<Subjects> subjectList ;


	public Teachers() {
		// TODO Auto-generated constructor stub
	}

	public int getTeacherId() {
		return TeacherId;
	}

	public void setTeacherId(int teacherId) {
		TeacherId = teacherId;
	}

	public String getTeachername() {
		return Teachername;
	}

	public void setTeachername(String teachername) {
		Teachername = teachername;
	}

	public List<Classes> getClassesList() {
		return classesList;
	}

	public void setClassesList(List<Classes> classesList) {
		this.classesList = classesList;
	}

	public List<Subjects> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<Subjects> subjectList) {
		this.subjectList = subjectList;
	}

	@Override
	public String toString() {
		return "Teachers [TeacherId=" + TeacherId + ", Teacher_name=" + Teachername + ", classesList=" + classesList
				+ ", subjectList=" + subjectList + "]";
	}

	
}
