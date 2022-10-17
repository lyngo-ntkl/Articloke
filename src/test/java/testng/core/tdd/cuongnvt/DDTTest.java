
package testng.core.tdd.cuongnvt;

import Respiratory.User.UserDAO;
import Respiratory.User.UserDTO;
import java.sql.SQLException;
import junit.framework.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTTest {
    
    //1. Test getUserUsername(String name)
    @DataProvider(name = "UserRepository")
    public static  Object[][] userRepo(){
        return new Object[][]{{ new UserDTO("nhoc_ddd",
            "cuong1832002@gmail.com", "cuongpro123",
       "Nguyen Van Tu", "Cuong", "Image/nhoc_ddd.png", "Administrator", null
       , "53 Tan Lap 1, Hiep Phu, 9 District, Ho Chi Minh City", null, "0828678897", true)
    }};}
    @Test(dataProvider = "UserRepository")
    public void getUserUsernameTest(UserDTO expected) throws SQLException, ClassNotFoundException{
        String actual = UserDAO.getUserUsername("nhoc_ddd").getUsername();
        Assert.assertEquals(actual, expected.getUsername());
    }
    
    public DDTTest() {
    }
    
}
