package JavaTest.controller.statistic;

import JavaTest.entities.QuestionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("/stat")
public class StatisticController {
    private StatisticModel statisticModel;

    @Autowired
    public StatisticController(StatisticModel statisticModel) {
        this.statisticModel = statisticModel;
    }

    @RequestMapping(path = "getSimple", method = RequestMethod.GET)
    @ResponseBody
    public List<QuestionEntity> getSimple(){
        return statisticModel.getSimpleQuestions();
    }

    @RequestMapping(path = "getDifficult", method = RequestMethod.GET)
    @ResponseBody
    public List<QuestionEntity> getDifficult(){
        return statisticModel.getDifficultQuestions();
    }

}
