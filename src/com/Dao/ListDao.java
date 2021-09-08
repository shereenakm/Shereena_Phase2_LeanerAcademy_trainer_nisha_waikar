package com.Dao;

import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.Classes;
import com.bean.Student;
import com.bean.Subjects;
import com.bean.Teachers;
import com.util.Connection;

public class ListDao {
	public List<Teachers> teacherslist() {
		Transaction transcation = null;
		List<Teachers> teacherlist = null;
		try {
			Session session = Connection.getFactory().openSession();
			transcation = session.beginTransaction();
			String hql = "FROM Teachers";
			TypedQuery<Teachers> query = session.createQuery(hql);
			teacherlist= query.getResultList();
		} catch (HibernateException e) {
			if (transcation != null) {
				transcation.rollback();
			}
			e.printStackTrace();
		}
		return teacherlist;
		

	}
	public List<Student> studentlist() {
		Transaction transcation = null;
		List<Student> studentlist = null;
		try {
			Session session = Connection.getFactory().openSession();
			transcation = session.beginTransaction();
			String hql = "FROM Student";
			TypedQuery<Student> query2 = session.createQuery(hql);
			studentlist= query2.getResultList();
		} catch (HibernateException e) {
			if (transcation != null) {
				transcation.rollback();
			}
			e.printStackTrace();
		}
		return studentlist;
		

	}
	public List<Classes> classlist() {
		Transaction transcation = null;
		List<Classes> classlist = null;
		try {
			Session session = Connection.getFactory().openSession();
			transcation = session.beginTransaction();
			String hql = "FROM Classes";
			TypedQuery<Classes> query3 = session.createQuery(hql);
			classlist = query3.getResultList();
		} catch (HibernateException e) {
			if (transcation != null) {
				transcation.rollback();
			}
			e.printStackTrace();
		}
		return classlist;
	}

	
	public List<Subjects> subjectlist () {
		Transaction transcation = null;
		List<Subjects> subjectlist = null;
		try {
			Session session = Connection.getFactory().openSession();
			transcation = session.beginTransaction();
			String hql = "FROM Subjects";
			TypedQuery<Subjects> query4 = session.createQuery(hql);	
			subjectlist = query4.getResultList();
		} catch (HibernateException e) {
			if (transcation != null) {
				transcation.rollback();
			}
			e.printStackTrace();
		}
		return subjectlist;
}
}
