package org.example.Dao;

import config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ForecastDao {

    SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

    public void save(ForecastDao forecastDao) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(forecastDao);
        transaction.commit();
    }
}
