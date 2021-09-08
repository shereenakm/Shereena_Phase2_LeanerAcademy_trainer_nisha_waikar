package com.Dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.Classes;
import com.bean.Teachers;
import com.util.Connection;

public class TeachersDao {
	public void addteacher(String teachername) {
	Transaction transcation = null;
	try {
		Session session = Connection.getFactory().openSession();
		transcation = session.beginTransaction();
		Teachers teacher = new Teachers();
		teacher.setTeachername(teachername);
		session.save(teacher);
		transcation.commit();
	} catch (HibernateException e) {
		if (transcation != null) {
			transcation.rollback();
		}
		e.printStackTrace();
	}
	
	
	
}
	public void teacher_class(int teacherid ,int classid ) {
		Transaction transcation = null;
		try {
			Session session = Connection.getFactory().openSession();
			transcation = session.beginTransaction();
			Teachers teacher2 = new Teachers();
			Classes classes = new Classes();
			teacher2= session.get(Teachers.class,teacherid);
			classes = session.get(Classes.class,classid);
			classes.getTeacher().add(teacher2);
			teacher2.getClassesList().add(classes);
			session.update(teacher2);
			session.update(classes);
			transcation.commit();
		} catch (HibernateException e) {
			if (transcation != null) {
				transcation.rollback();
			}
			e.printStackTrace();
		}
		
		
		
	}
}
