package com.Dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.Admin;
import com.util.Connection;

public class AdminDao {

	
	public void updateadmin(String username,String password ) {
		Transaction transcation = null;
		try {
			Session session = Connection.getFactory().openSession();
			transcation = session.beginTransaction();
			Admin admin = session.get(Admin.class,1);
			admin.setPassword(password);
			admin.setUsername(username);
			session.update(admin);
			transcation.commit();
		} catch (HibernateException e) {
			if (transcation != null) {
				transcation.rollback();
			}
			e.printStackTrace();

		}
	}
	
	public Admin giveadmin() {
		Transaction transcation = null;
		Admin getadmin = null;
		try {
			Session session = Connection.getFactory().openSession();
			transcation = session.beginTransaction();
			getadmin = session.get(Admin.class, 1);
			transcation.commit();
		} catch (HibernateException e) {
			if (transcation != null) {
				transcation.rollback();
			}
			e.printStackTrace();

		}
		return getadmin;
	}
	public void addadmin() {
		Transaction transcation = null;
		try {
			Session session = Connection.getFactory().openSession();
			transcation = session.beginTransaction();
			Admin addadmin = new Admin("leaner","java");
			session.save(addadmin);
			transcation.commit();
		} catch (HibernateException e) {
			if (transcation != null) {
				transcation.rollback();
			}
			e.printStackTrace();

		}
		
	}
	
}


