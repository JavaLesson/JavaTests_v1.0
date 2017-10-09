package JavaTest.controller.statistic;

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

    @RequestMapping(path = "geteasy", method = RequestMethod.GET)
    @ResponseBody
    public List getEasy(){
        return statisticModel.getEasyQuestions();
    }

    @RequestMapping(path = "getdifficult", method = RequestMethod.GET)
    @ResponseBody
    public List getDifficult(){
        return statisticModel.getDifficultQuestions();
    }

}
