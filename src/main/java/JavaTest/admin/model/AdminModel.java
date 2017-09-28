package JavaTest.admin.model;

import JavaTest.HibernateSessionFactory;
import JavaTest.TestEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/*in model is data access layer*/
@Repository
public class AdminModel {

    public void create(TestEntity testEntity){
        Session session = HibernateSessionFactory.start();
        session.beginTransaction();
        session.save(testEntity);
        session.flush();
        session.getTransaction().commit();
        session.close();
    }

    public void delete(TestEntity testEntity){
        Session session = HibernateSessionFactory.start();
        session.beginTransaction();
        session.delete(testEntity);
        session.getTransaction().commit();
        session.close();
    }
}
