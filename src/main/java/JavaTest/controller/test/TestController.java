package JavaTest.controller.test;

import JavaTest.entities.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {
    private TestModel testModel;

    @Autowired
    public TestController(TestModel testModel) {
        this.testModel = testModel;
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public void createTest(@RequestBody TestEntity testEntity){
        testModel.create(testEntity);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void updateTest(@RequestBody TestEntity testEntity){
        testModel.update(testEntity);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteTest(@RequestBody TestEntity testEntity){
        testModel.delete(testEntity);
    }
}
