
package testng.core.tdd.cuongnvt;

import Respiratory.User.UserDAO;
import Respiratory.User.UserDTO;
import java.sql.SQLException;
import org.testng.Assert;

import org.testng.annotations.Test;

public class TDDTest {
    
    //1. Test getUserUsername(String username) inside UserDTO.java
    @Test
    public void getUserUsernameTest()
            throws SQLException, ClassNotFoundException{
        // expected when SQLQuery "SELECT * FROM User_ WHERE Username = "nhoc_ddd" is written
        UserDTO expected = new UserDTO("nhoc_ddd",
            "cuong1832002@gmail.com", "cuongpro123",
       "Nguyen Van Tu", "Cuong", "Image/nhoc_ddd.png", "Administrator", null
       , "53 Tan Lap 1, Hiep Phu, 9 District, Ho Chi Minh City", null, "0828678897", true);
        // actual
        UserDTO actual = UserDAO.getUserUsername("nhoc_ddd");
      
        Assert.assertEquals(expected.getPassword(), actual.getPassword() );
      //  Assert.assertEquals(expected.getDOB(), actual.getDOB());
               
    }
    
    //2.  Test getUsers() inside UserDTO.java
    @Test
    public void getUsersTest() throws SQLException, ClassNotFoundException{
       // Test Usernames
        String[] expected = {"Florentino", "nhoc_ddd", "starci"};  
        String[] actual = new String[3];
        for (int i = 0; i < 3; i++){
            actual[i] = UserDAO.getUsers().get(i).getUsername();   
        }
       Assert.assertEquals(actual, expected);
       // Test Password
    }
    
    
    public TDDTest() {
    }
    
}
