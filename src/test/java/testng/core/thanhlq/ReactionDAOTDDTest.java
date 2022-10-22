package testng.core.thanhlq;

import Respiratiory.Reaction.ReactionDAO;
import java.sql.SQLException;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author lequa
 */
public class ReactionDAOTDDTest {

    @Test(priority = 1, description = "this test total of reaction with name given equal value given")
    public void getTotalReactionTest() throws ClassNotFoundException, SQLException {
        /*Expected when SQLQuey SELECT COUNT(re.ID) as totalReaction FROM\n"
                + "Reaction re inner join Paper pp ON re.ID = pp.ID\n"
                + "WHERE pp.username = ?\n"
                + "GROUP BY pp.username  is execute*/
        System.out.println("Get Total Reaction");
        //Case 1: Florentino 
        Assert.assertEquals(ReactionDAO.getTotalReaction("Florentino"), 0);
        //Case 2: nhoc_ddd
        Assert.assertEquals(ReactionDAO.getTotalReaction("nhoc_ddd"), 0);
        //Case 3: starci
        Assert.assertEquals(ReactionDAO.getTotalReaction("starci"), 18);
    }

    @Test(priority = 3, dependsOnMethods = {"getTotalReactionTest"}, description = "this test true or false when delete in SQL", invocationCount = 2)
    public void deleteReactionTest() throws SQLException, ClassNotFoundException {
        /* Expected when SQLQuery DELETE FROM Reaction WHERE ID = ? AND username = ? is execute */
        System.out.println("Delete Reaction");
        //Case 1: false when wrong input advailable in database
        Assert.assertEquals(ReactionDAO.deleteReaction("ARS3", "abc"), false);
        //case 2: false when input does not esxits in database
        Assert.assertEquals(ReactionDAO.deleteReaction("AR012", "nhoc_ddd"), false);
        //case 3: true when correct input
         Assert.assertEquals(ReactionDAO.deleteReaction("AR009", "nhoc_ddd"), true);
    }

    @Test(priority = 2, description = "this test true or false when insert into SQL")
    public void addReactionTest() throws SQLException, ClassNotFoundException {
        /* Epected when SQLQuery INSERT INTO Reaction(ID, username) VALUES(?,?) is execute */
        System.out.println("Add Reaction");
        //Case 1: True when correct input ID is not same in database
        Assert.assertEquals(ReactionDAO.addReaction("AR012", "nhoc_ddd"), true);
    }
    //enabled = false

    @Test(description = "this is test value return from table reaction same as value given input or not",
            dependsOnMethods = {"addReactionTest", "deleteReactionTest"}, timeOut = 100)
    public void checkReactionTest() throws ClassNotFoundException, SQLException {
        /* Expected when SQLQuery SELECT * FROM Reaction WHERE ID = ? AND username = ? is execute */
        System.out.println("Check Reaction");
        //Case 1: ID = AR001 , UserName = starci
        Assert.assertEquals(ReactionDAO.checkReaction("AR001", "starci"), true);
        //Case 2: ID = AR001 , UserName = nhoc_ddd
        Assert.assertEquals(ReactionDAO.checkReaction("AR001", "nhoc_ddd"), true);
        //Case 3: ID = AR002 , UserName = starci
        Assert.assertEquals(ReactionDAO.checkReaction("AR002", "starci"), true);
        //Case 4: ID = AR003 , UserName = nhoc_ddd
        Assert.assertEquals(ReactionDAO.checkReaction("AR003", "nhoc_ddd"), true);
        //Case 5: ID = AR004 , UserName = nhoc_ddd
        Assert.assertEquals(ReactionDAO.checkReaction("AR004", "nhoc_ddd"), true);
        //Case 6: ID = AR005 , UserName = starci
        Assert.assertEquals(ReactionDAO.checkReaction("AR005", "starci"), true);
        //Case 7: ID = AR006 , UserName = nhoc_ddd
        Assert.assertEquals(ReactionDAO.checkReaction("AR006", "nhoc_ddd"), false);
        //Case 8: ID = AR007 , UserName = starci
        Assert.assertEquals(ReactionDAO.checkReaction("AR007", "starci"), true);
        //Case 9: ID = AR008 , UserName = starci
        Assert.assertEquals(ReactionDAO.checkReaction("AR008", "starci"), true);
        //Case 10: ID = AR009 , UserName = nhoc_ddd
        Assert.assertEquals(ReactionDAO.checkReaction("AR009", "nhoc_ddd"), true);
        //Case 11: ID = AR010 , UserName = nhoc_ddd
        Assert.assertEquals(ReactionDAO.checkReaction("AR010", "nhoc_ddd"), false);
        //Case 12: Others
        Assert.assertEquals(ReactionDAO.checkReaction("", ""), false);
    }
}
