package org.example;

import org.example.entities.Hospital;
import org.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class TestRepository {
    public Hospital findHospital(int hospitalID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.get(Hospital.class, hospitalID);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        session.close();
        return null;
    }
}
