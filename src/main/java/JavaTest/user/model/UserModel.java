package JavaTest.user.model;

import JavaTest.HibernateSessionFactory;
import JavaTest.TestEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class UserModel {
    private static final Session session = HibernateSessionFactory.getSessionFactory().openSession();

    public TestEntity getTestData(int testId){
        session.beginTransaction();
        TestEntity testEntity = session.get(TestEntity.class, testId);
        session.flush();
        session.getTransaction().commit();
        return testEntity;
    }
}
