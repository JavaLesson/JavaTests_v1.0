package JavaTest.controller.statistic;

import JavaTest.HibernateSessionFactory;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class StatisticModel {

    public HashMap getStatistic(){
        Session session = HibernateSessionFactory.start();
        session.beginTransaction();
        String HQL_QUERY =
                "select new map(questionId, sum(case when correct = 1 then 1 else 0 end) / count(questionId) * 100) "
                + "from StatisticEntity group by questionId";
        List<Map> list = session.createQuery(HQL_QUERY).list();
        HashMap map = new HashMap<Integer, Long>();
        for (Map m : list) {
            map.put(m.get("0"), m.get("1"));
        }
        session.flush();
        session.close();

        return map;
    }

    public List getEasyQuestions(){
        HashMap<Integer, Long> map = getStatistic();
        List list = map.entrySet().stream().filter(entry -> entry.getValue() >= 80)
                .map(entry -> entry.getKey()).collect(Collectors.toList());

        return list;
    }

    public List getDifficultQuestions(){
        HashMap<Integer, Long> map = getStatistic();
        List list = map.entrySet().stream().filter(entry -> entry.getValue() <= 20)
                .map(entry -> entry.getKey()).collect(Collectors.toList());

        return list;
    }

}
