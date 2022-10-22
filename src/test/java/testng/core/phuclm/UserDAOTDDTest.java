package testng.core.phuclm;
import Respiratory.User.UserDAO;
import java.sql.SQLException;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
public class UserDAOTDDTest {
   //1.Test GetUsernameusernamePassword inside UserDTO.java
    @Test
    public void testGetUsernameusernamePassword ()throws SQLException, ClassNotFoundException{
    String expected [] = {"Florentino", "nhoc_ddd", "starci"};
    String[] actual = new String[3];
        for (int i = 0; i < 3; i++){
            actual[i] = UserDAO.getUsers().get(i).getUsername();   
        }
       Assert.assertEquals(actual, expected);

       String expected1 [] = {"cuongdeptrai", "cuongpro123", "123456"};
    String[] actual1 = new String[3];
        for (int i = 0; i < 3; i++){
            actual1[i] = UserDAO.getUsers().get(i).getPassword();   
        }
       Assert.assertEquals(actual1, expected1);
} 
}