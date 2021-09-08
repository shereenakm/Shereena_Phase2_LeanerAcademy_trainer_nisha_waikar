package com.Dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.Classes;
import com.bean.Subjects;
import com.bean.Teachers;
import com.util.Connection;

public class SubjectsDao {
	public void addsubject(String  subjectname) {
		
		Transaction transcation = null;
		try {
			Session session = Connection.getFactory().openSession();
			transcation = session.beginTransaction();
			Subjects subject =  new Subjects();
			subject.setSubjectname(subjectname);
			session.save(subject);
			transcation.commit();
		} catch (HibernateException e) {
			if (transcation != null) {
				transcation.rollback();
			}
			e.printStackTrace();
			
		}
		
	}
	public void subject_teacher(int subjectid,int teacherid) {
		Transaction transcation = null;
		try {
			Session session = Connection.getFactory().openSession();
			transcation = session.beginTransaction();
			Subjects subject2 =  new Subjects();
			Teachers teacher = new Teachers();
			subject2=session.get(Subjects.class,subjectid);
			teacher=session.get(Teachers.class,teacherid);
			subject2.setTeacher(teacher);
			teacher.getSubjectList().add(subject2);
			session.update(teacher);
			session.update(subject2);
			transcation.commit();
		} catch (HibernateException e) {
			if (transcation != null) {
				transcation.rollback();
			}
			e.printStackTrace();

		}
	}
	public void subject_class(int subjectid2,int classid) {
		Transaction transcation = null;
		try {
			Session session = Connection.getFactory().openSession();
			transcation = session.beginTransaction();
			Subjects subject3 =  new Subjects();
			Classes classes = new Classes();
			subject3=session.get(Subjects.class,subjectid2);
			classes=session.get(Classes.class,classid);
			subject3.setClasses(classes);
			classes.getSubjectList().add(subject3);
			session.update(classes);
			session.update(subject3);
			transcation.commit();
		} catch (HibernateException e) {
			if (transcation != null) {
				transcation.rollback();
			}
			e.printStackTrace();

		}
	}
	
}
