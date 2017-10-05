package JavaTest.user.controller;

import JavaTest.entities.UserEntity;
import JavaTest.user.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    UserModel userModel;

    @Autowired
    UserController(UserModel userModel){
        this.userModel = userModel;
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public void createUser(@RequestBody UserEntity userEntity){
        userModel.create(userEntity);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void updateUser(@RequestBody UserEntity userEntity){
        userModel.update(userEntity);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteUser(@RequestBody UserEntity userEntity){
        userModel.delete(userEntity);
    }
}
