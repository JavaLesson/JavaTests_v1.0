package JavaTest.controller.statistic;

import JavaTest.HibernateSessionFactory;
import JavaTest.entities.QuestionEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class StatisticModel {

    public List<QuestionEntity> getSimpleQuestions(){
        Session session = HibernateSessionFactory.start();
        session.beginTransaction();
        String SQL_QUERY = "SELECT * FROM javatests.question WHERE question.questionId IN (" +
                "SELECT t1.questionId FROM (" +
                "SELECT statistic.questionId, SUM(CASE WHEN correct = 1 THEN 1 ELSE 0 END ) / " +
                "count(statistic.questionId) * 100 as stat FROM javatests.statistic GROUP BY statistic.questionId HAVING stat >= 80) as t1)";
        List<QuestionEntity> list = session.createSQLQuery(SQL_QUERY).addEntity(QuestionEntity.class).list();
        session.flush();
        session.close();

        return list;
    }

    public List<QuestionEntity> getDifficultQuestions(){
        Session session = HibernateSessionFactory.start();
        session.beginTransaction();
        String SQL_QUERY = "SELECT * FROM javatests.question WHERE question.questionId IN (" +
                "SELECT t1.questionId FROM (" +
                "SELECT statistic.questionId, SUM(CASE WHEN correct = 1 THEN 1 ELSE 0 END ) / " +
                "count(statistic.questionId) * 100 as stat FROM javatests.statistic GROUP BY statistic.questionId HAVING stat <= 20) as t1)";
        List<QuestionEntity> list = session.createSQLQuery(SQL_QUERY).addEntity(QuestionEntity.class).list();
        session.flush();
        session.close();

        return list;
    }
    
}
