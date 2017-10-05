package JavaTest.tutor.controller;

import JavaTest.entities.UserEntity;
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

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public void createUser(@RequestBody UserEntity userEntity){
        tutorModel.create(userEntity);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void updateUser(@RequestBody UserEntity userEntity){
        tutorModel.update(userEntity);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteUser(@RequestBody UserEntity userEntity){
        tutorModel.delete(userEntity);
    }
}
