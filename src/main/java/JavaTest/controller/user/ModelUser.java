package JavaTest.controller.user;

import JavaTest.HibernateSessionFactory;
import JavaTest.entities.UserEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class ModelUser {

    public void create(UserEntity userEntity){
        Session session = HibernateSessionFactory.start();
        session.beginTransaction();
        session.save(userEntity);
        session.flush();
        session.getTransaction().commit();
        session.close();
    }

    public void update(UserEntity userEntity){
        Session session = HibernateSessionFactory.start();
        session.beginTransaction();
        session.update(userEntity);
        session.flush();
        session.getTransaction().commit();
        session.close();
    }

    public void delete(UserEntity userEntity){
        Session session = HibernateSessionFactory.start();
        session.beginTransaction();
        session.delete(userEntity);
        session.flush();
        session.getTransaction().commit();
        session.close();
    }

}
