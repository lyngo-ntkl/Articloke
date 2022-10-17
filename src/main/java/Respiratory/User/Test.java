
package Respiratory.User;

import java.sql.Date;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Date date=new Date(2000, 11, 1);
        UserDTO user = new UserDTO("kahlii", null, "cuongdeptrai", "StarCi", "da Philosopher", null, "User", null, null, null, null, true);
        //UserDAO.addUser(usernew);
        System.out.println(UserDAO.addUser(user));
        //System.out.println(UserDAO.updateUser("aaa", usernew));
        //System.out.println(UserDAO.removeUser("aaa"));     
    }
}
