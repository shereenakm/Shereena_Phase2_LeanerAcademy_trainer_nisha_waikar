package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Connection {
private static SessionFactory factory;



public static SessionFactory getFactory() {
	 if (factory == null) {
		 try {
			Configuration configuration = new Configuration().configure();
			configuration.addAnnotatedClass(com.bean.Classes.class);
			configuration.addAnnotatedClass(com.bean.Subjects.class);
			configuration.addAnnotatedClass(com.bean.Teachers.class);
			configuration.addAnnotatedClass(com.bean.Student.class);
			configuration.addAnnotatedClass(com.bean.Admin.class);
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties());
			factory = configuration.buildSessionFactory(builder.build());
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }	
	return factory;
} 


}
