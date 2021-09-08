package com.Dao;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.Classes;
import com.bean.Student;
import com.util.Connection;

public class StudentDao {
	public void addstudenttoclass(String studentname,int classid) {
		Transaction transcation = null;
		try {
			Session session = Connection.getFactory().openSession();
			transcation = session.beginTransaction();
			Classes classes = new Classes(); 
			classes=session.get(Classes.class,classid);
			Student student = new Student(studentname,classes);
			classes.getStudent().add(student);
			
			session.update(classes);
			session.save(student);
			transcation.commit();
		} catch (HibernateException e) {
			if (transcation != null) {
				transcation.rollback();
			}
			e.printStackTrace();

		}
	}

}
