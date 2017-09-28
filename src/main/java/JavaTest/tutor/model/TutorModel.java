package JavaTest.tutor.model;

import JavaTest.HibernateSessionFactory;
import JavaTest.TestEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class TutorModel {

    public void update(TestEntity testEntity){
        Session session = HibernateSessionFactory.start();
        session.beginTransaction();
        session.saveOrUpdate(testEntity);
        session.flush();
        session.getTransaction().commit();
        session.close();
    }
}
