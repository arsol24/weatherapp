package org.example.Dao;

import config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CurrentWeatherDao {

    SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

    public void save(CurrentWeatherDao currentWeatherDao) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(currentWeatherDao);
        transaction.commit();
    }
}
