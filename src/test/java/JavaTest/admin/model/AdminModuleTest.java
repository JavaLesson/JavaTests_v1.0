package JavaTest.admin.model;

import JavaTest.Application;
import JavaTest.TestEntity;
import JavaTest.user.model.UserModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
public class AdminModuleTest {
    @Autowired
    private AdminModel adminModel;
    @Autowired
    private UserModel userModel;
    @Test
    public void updateTest(){
        TestEntity testEntity = new TestEntity();
        testEntity.setData("test");
        testEntity.setName("test");
        testEntity.setTestId(4);
        adminModel.create(testEntity);
        if(testEntity.equals(userModel.getTestData(testEntity.getTestId()))){
            System.out.println("TEST IS SUCCESSFUL");
        }
        assertNotNull(userModel.getTestData(testEntity.getTestId()));
        adminModel.delete(testEntity);
    }
}
