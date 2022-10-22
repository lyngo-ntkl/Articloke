/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package testng.core.thanhlq;

import Respiratiory.Reaction.ReactionDAO;
import java.sql.SQLException;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author lequa
 */
public class ReactionDAODDTTest {

    @DataProvider(name = "Data")
    public static Object[][] Data() {
        return new Object[][]{{0, "Florentino"}, {0, "nhoc_ddd"}, {18, "starci"}};
    }

    @Test(dataProvider = "Data", description = "This is test total reaction")
    public void getTotalReactionTest(int total, String name) throws ClassNotFoundException, SQLException {
        Assert.assertEquals(ReactionDAO.getTotalReaction(name), total);
    }

    @DataProvider(name = "Data1")
    public static Object[][] Data1() {
        return new Object[][]{{"AR012", "nhoc_ddd", true}, {"AR003", "nhoc_ddd", false}};
    }

    @Test(dataProvider = "Data1", description = "This is test add reaction")
    public void addReactionTest(String id, String name, boolean result) throws ClassNotFoundException, SQLException {
        Assert.assertEquals(ReactionDAO.addReaction(id, name), result);
    }

    @DataProvider(name = "Data2")
    public static Object[][] Data2() {
        return new Object[][]{{"ARS3", "abc", false}, {"AR012", "nhoc_ddd", false}, {"AR009", "nhoc_ddd", true}};
    }

    @Test(dataProvider = "Data2", description = "This is test delete reaction")
    public void deleteReactionTest(String id, String name, boolean result) throws ClassNotFoundException, SQLException {
        Assert.assertEquals(ReactionDAO.deleteReaction(id, name), result);
    }
}
