package com.Dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.Classes;
import com.util.Connection;

public class ClassesDao {
	public void addclasses(String  class_name) {
		Transaction transcation = null;
		try {
			Session session = Connection.getFactory().openSession();
			transcation = session.beginTransaction();
			Classes classes = new Classes(class_name);
			session.save(classes);
			transcation.commit();
		} catch (HibernateException e) {
			if (transcation != null) {
				transcation.rollback();
			}
			e.printStackTrace();

		}
	}

	public Classes giveclass(int classid ) {
		Transaction transcation= null;
		Classes classes =null;
		try {
			Session session = Connection.getFactory().openSession();
			 transcation =session.beginTransaction();
			 classes =session.get(Classes.class,classid);
			transcation.commit();
		} catch (HibernateException e) {
			if(transcation !=null) {
				 transcation.rollback();
			}
			e.printStackTrace();
			
		}
		return classes;	
	}

}
