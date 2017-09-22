package JavaTest.tutor.controller;

import JavaTest.TestEntity;
import JavaTest.tutor.model.TutorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/tutor")
public class TutorController {
    TutorModel tutorModel;

    @Autowired
    TutorController(TutorModel tutorModel){
        this.tutorModel = tutorModel;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void updateTest (@RequestBody TestEntity testEntity){
        tutorModel.update(testEntity);
    }
}
