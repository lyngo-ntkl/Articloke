/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package testng.core.lyntk;

import Respiratory.Paper.PaperDAO;
import Respiratory.Paper.PaperDTO;
import java.util.List;
import java.sql.SQLException;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author LyNgo
 */
public class PaperDAOTDDTest {
    
    @Test
    public static void testGetPapersUsernameLastedModifiedDate() throws SQLException, ClassNotFoundException{
        List<PaperDTO> list = PaperDAO.getPapersUsernameLastedModifiedDate("starci");
        String[] actual = new String[9];
        for(int i=0; i<9; i++){
            actual[i] = list.get(i).getID();
        }
        String[] expected = new String[] {
            "AR009",
            "AR002",
            "AR004",
            "AR003",
            "AR008",
            "AR001",
            "AR006",
            "AR007",
            "AR005"
        };
        Assert.assertEquals(actual, expected);
    }
}