package com.example.util;

import com.example.Product;
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
						.addAnnotatedClass(Product.class)
						.buildSessionFactory();
			}
		}
		return factory;
	}
}