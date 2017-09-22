package JavaTest.tutor.model;

import JavaTest.HibernateSessionFactory;
import JavaTest.TestEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class TutorModel {
    public static final Session session = HibernateSessionFactory.getSessionFactory().openSession();

    public void update(TestEntity testEntity){
        session.beginTransaction();
        session.saveOrUpdate(testEntity);
        session.flush();
        session.getTransaction().commit();
    }
}
