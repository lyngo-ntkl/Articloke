
package Respiratory.Paper;
import java.sql.SQLException;

public class Test {
     public static void main(String[] args) 
            throws SQLException, ClassNotFoundException{

        System.out.println(PaperDAO.getPapersUsernameLastedModifiedDate("starci"));
    }
}
