package JavaTest.controller.user;

import JavaTest.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/use")
public class ControllerUser {
    private ModelUser modelUser;

    @Autowired
    public ControllerUser(ModelUser modelUser) {
        this.modelUser = modelUser;
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public void createUser (@RequestBody UserEntity userEntity){
        modelUser.create(userEntity);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void updateUser (@RequestBody UserEntity userEntity){
        modelUser.update(userEntity);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteUser (@RequestBody UserEntity userEntity){
        modelUser.delete(userEntity);
    }

}
