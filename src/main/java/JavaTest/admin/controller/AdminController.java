package JavaTest.admin.controller;

/*in controller bysness logic and work with client data*/

import JavaTest.TestEntity;
import JavaTest.admin.model.AdminModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    AdminModel adminModel;

    @Autowired
    AdminController(AdminModel adminModel){
        this.adminModel = adminModel;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void createTest (@RequestBody TestEntity testEntity){
        /*System.out.println("get Entity Name - " + testEntity.getName());
        System.out.println("get Entity Data - " + testEntity.getData());
        System.out.println("get Entity TestId - " + testEntity.getTestId());*/
        adminModel.create(testEntity);
    }
    @RequestMapping(path = "/delete/{userId}",method = RequestMethod.DELETE)
    @ResponseBody
    public void createTest (@PathVariable ("userId") int userId){
        TestEntity testEntity = new TestEntity();
        testEntity.setTestId(userId);
        /*System.out.println("get Entity Name - " + testEntity.getName());
        System.out.println("get Entity Data - " + testEntity.getData());
        System.out.println("get Entity TestId - " + testEntity.getTestId());*/
        adminModel.delete(testEntity);
    }
}
