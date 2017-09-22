package JavaTest.user.controller;

import JavaTest.TestEntity;
import JavaTest.user.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    UserModel userModel;

    @Autowired
    UserController(UserModel userModel){
        this.userModel = userModel;
    }

    @RequestMapping(path = "/{testId}",method = RequestMethod.GET)
    @ResponseBody
    public TestEntity updateTest (@PathVariable ("testId") int testId){
        TestEntity testEntity = userModel.getTestData(testId);
        return testEntity;
    }
}
