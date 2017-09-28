package JavaTest.user.model;

import JavaTest.HibernateSessionFactory;
import JavaTest.TestEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class UserModel {

    public TestEntity getTestData(int testId){
        Session session = HibernateSessionFactory.start();
        session.beginTransaction();
        TestEntity testEntity = session.get(TestEntity.class, testId);
        session.flush();
        session.getTransaction().commit();
        session.close();
        return testEntity;
    }
}
