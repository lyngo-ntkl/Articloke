package testng.core.phuclm;


import Respiratory.User.UserDAO;
import Respiratory.User.UserDTO;
import java.sql.SQLException;
import junit.framework.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserDAODDTTest {
    
    //1. Test getUserUsername(String name)
    @DataProvider(name = "Test1")
    public static  Object[][] initTest1(){
        return new Object[][]{{ new UserDTO("Florentino",
            "florentino@gmai.com", "cuongdeptrai",
       "StarCi", "da Philosopher", "Image/StarCidaPhilosopher.png", "Reviewer",null
       , "", "FPT", null, true)
    }};}
    @Test(dataProvider = "Test1")
    public void getUserUsernameTest(UserDTO expected) throws SQLException, ClassNotFoundException{
        String actual = UserDAO.getUserUsername("florentino@gmai.com").getEmail();
        Assert.assertEquals(actual, expected.getEmail());
    }
     
    @DataProvider(name = "Test2")
    public static Object[][]initTest2(){
        return new Object[][]{{"Florentino","cuongdeptrai"},{"nhoc_ddd","cuongpro123"}
    };
    }
    @Test(dataProvider = "Test2")
    public void testGetUsernameusernamePassword(String username,String password) throws SQLException, ClassNotFoundException{ 
        Assert.assertEquals(UserDAO.getUserUsernamePassword(username, password), initTest2());
    }
    }