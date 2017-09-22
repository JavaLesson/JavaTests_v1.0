package JavaTest.admin.model;

import JavaTest.HibernateSessionFactory;
import JavaTest.TestEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/*in model is data access layer*/
@Repository
public class AdminModel {
    public static final Session session = HibernateSessionFactory.getSessionFactory().openSession();

    public void create(TestEntity testEntity){
        session.beginTransaction();
        session.save(testEntity);
        session.flush();
        session.getTransaction().commit();
    }
}
