package org.example.util;

import org.example.entities.Doctor;
import org.example.entities.Drug;
import org.example.entities.Hospital;
import org.example.entities.Patient;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static volatile SessionFactory factory;

	private HibernateUtil() {
	}

	public static SessionFactory getSessionFactory() {
		if (factory == null) {
			synchronized (SessionFactory.class) {
				factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Hospital.class)
						.addAnnotatedClass(Doctor.class)
						.addAnnotatedClass(Patient.class)
						.addAnnotatedClass(Drug.class)
						.buildSessionFactory();
			}
		}
		return factory;
	}
}