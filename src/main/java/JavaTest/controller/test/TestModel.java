package JavaTest.controller.test;

import JavaTest.HibernateSessionFactory;
import JavaTest.entities.TestEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class TestModel {
    public void create(TestEntity testEntity){
        Session session = HibernateSessionFactory.start();
        session.beginTransaction();
        session.save(testEntity);
        session.flush();
        session.getTransaction().commit();
        session.close();
    }

    public void update(TestEntity testEntity){
        Session session = HibernateSessionFactory.start();
        session.beginTransaction();
        session.update(testEntity);
        session.flush();
        session.getTransaction().commit();
        session.close();
    }

    public void delete(TestEntity testEntity){
        Session session = HibernateSessionFactory.start();
        session.beginTransaction();
        session.delete(testEntity);
        session.flush();
        session.getTransaction().commit();
        session.close();
    }
}
