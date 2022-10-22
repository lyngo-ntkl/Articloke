/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package testng.core.lyntk;

import Respiratory.Paper.PaperDAO;
import Respiratory.Paper.PaperDTO;
import java.sql.Date;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author LyNgo
 */
public class PaperDAODDTTest {

    @DataProvider(name = "test1")
    public Object[][] initTest1() {
        return new Object[][]{
            {"Florentino", null},
            {"starci", new ArrayList<PaperDTO>() {
                {
                    add(new PaperDTO("AR009", "Kirito", null, "Environment", "yet", "sos", Date.valueOf("2099-02-02"), Date.valueOf("2099-03-03"), "starci", "Published", true));
                    add(new PaperDTO("AR002", "Kahlii", "Image/Article/AR002.png", "Mathematics", "yet", "sos", Date.valueOf("2023-01-11"), Date.valueOf("2033-01-11"), "starci", "Published", true));
                    add(new PaperDTO("AR004", "Zata", "Image/Article/AR004.jpg", "Mathematics", "yet", "sos", Date.valueOf("2025-01-01"), Date.valueOf("2026-03-11"), "starci", "Published", true));
                    add(new PaperDTO("AR003", "Preyta", "Image/Article/AR003.jpg", "Mathematics", "yet", "sos", Date.valueOf("2024-02-02"), Date.valueOf("2025-03-01"), "starci", "Published", true));
                    add(new PaperDTO("AR008", "Ignis", null, "Environment", "yet", "sos", Date.valueOf("2055-02-02"), Date.valueOf("2025-02-01"), "starci", "Published", true));
                    add(new PaperDTO("AR001", "Florentino", "Image/Article/AR001.jpg", "Mathematics", "yet", "sos", Date.valueOf("2022-01-11"), Date.valueOf("2023-01-11"), "starci", "Published", true));
                    add(new PaperDTO("AR006", "Paine", "Image/Article/AR006.jpg", "Mathematics", "yet", "sos", Date.valueOf("2022-02-02"), Date.valueOf("2022-02-02"), "starci", "Published", true));
                    add(new PaperDTO("AR007", "Slimz", "Image/Article/AR007.jpg", "Mathematics", "yet", "sos", Date.valueOf("2023-02-02"), Date.valueOf("2022-02-02"), "starci", "Published", true));
                    add(new PaperDTO("AR005", "Tarra", "Image/Article/AR005.jpg", "Mathematics", "yet", "sos", Date.valueOf("2022-01-01"), Date.valueOf("2022-01-01"), "starci", "Published", true));
                }
            }}
        };
    }

    @Test(dataProvider = "test1")
    public static void testGetPapersUsernameLastedModifiedDate(String username, List<PaperDTO> papers) throws SQLException, ClassNotFoundException {
        Assert.assertEquals(PaperDAO.getPapersUsernameLastedModifiedDate(username), papers);
    }

    @DataProvider(name = "test2")
    public Object[][] initTest2() {
        return new Object[][]{
            {"Florentino", "A", null},
            {"starci", "A", new ArrayList<PaperDTO>() {
                {
                    add(new PaperDTO("AR001", "Florentino", "Image/Article/AR001.jpg", "Mathematics", "yet", "sos", Date.valueOf("2022-01-11"), Date.valueOf("2023-01-11"), "starci", "Published", true));
                    add(new PaperDTO("AR002", "Kahlii", "Image/Article/AR002.png", "Mathematics", "yet", "sos", Date.valueOf("2023-01-11"), Date.valueOf("2033-01-11"), "starci", "Published", true));
                    add(new PaperDTO("AR003", "Preyta", "Image/Article/AR003.jpg", "Mathematics", "yet", "sos", Date.valueOf("2024-02-02"), Date.valueOf("2025-03-01"), "starci", "Published", true));
                    add(new PaperDTO("AR004", "Zata", "Image/Article/AR004.jpg", "Mathematics", "yet", "sos", Date.valueOf("2025-01-01"), Date.valueOf("2026-03-11"), "starci", "Published", true));
                    add(new PaperDTO("AR005", "Tarra", "Image/Article/AR005.jpg", "Mathematics", "yet", "sos", Date.valueOf("2022-01-01"), Date.valueOf("2022-01-01"), "starci", "Published", true));
                    add(new PaperDTO("AR006", "Paine", "Image/Article/AR006.jpg", "Mathematics", "yet", "sos", Date.valueOf("2022-02-02"), Date.valueOf("2022-02-02"), "starci", "Published", true));
                    add(new PaperDTO("AR007", "Slimz", "Image/Article/AR007.jpg", "Mathematics", "yet", "sos", Date.valueOf("2023-02-02"), Date.valueOf("2022-02-02"), "starci", "Published", true));
                    add(new PaperDTO("AR008", "Ignis", null, "Environment", "yet", "sos", Date.valueOf("2055-02-02"), Date.valueOf("2025-02-01"), "starci", "Published", true));
                    add(new PaperDTO("AR009", "Kirito", null, "Environment", "yet", "sos", Date.valueOf("2099-02-02"), Date.valueOf("2099-03-03"), "starci", "Published", true));

                }
            }}
        };
    }

    @Test(dataProvider = "test2")
    public static void testGetPapersKeyword(String username, String keyword, List<PaperDTO> papers) throws SQLException, ClassNotFoundException {
        Assert.assertEquals(PaperDAO.getPapersKeyword(username, keyword), papers);
    }
    
    @DataProvider(name = "test3")
    public Object[][] initTest3() {
        return new Object[][]{
            {"Florentino", "A", "", null},
            {"starci", "A", "Mathematics", new ArrayList<PaperDTO>() {
                {
                    add(new PaperDTO("AR001", "Florentino", "Image/Article/AR001.jpg", "Mathematics", "yet", "sos", Date.valueOf("2022-01-11"), Date.valueOf("2023-01-11"), "starci", "Published", true));
                    add(new PaperDTO("AR002", "Kahlii", "Image/Article/AR002.png", "Mathematics", "yet", "sos", Date.valueOf("2023-01-11"), Date.valueOf("2033-01-11"), "starci", "Published", true));
                    add(new PaperDTO("AR003", "Preyta", "Image/Article/AR003.jpg", "Mathematics", "yet", "sos", Date.valueOf("2024-02-02"), Date.valueOf("2025-03-01"), "starci", "Published", true));
                    add(new PaperDTO("AR004", "Zata", "Image/Article/AR004.jpg", "Mathematics", "yet", "sos", Date.valueOf("2025-01-01"), Date.valueOf("2026-03-11"), "starci", "Published", true));
                    add(new PaperDTO("AR005", "Tarra", "Image/Article/AR005.jpg", "Mathematics", "yet", "sos", Date.valueOf("2022-01-01"), Date.valueOf("2022-01-01"), "starci", "Published", true));
                    add(new PaperDTO("AR006", "Paine", "Image/Article/AR006.jpg", "Mathematics", "yet", "sos", Date.valueOf("2022-02-02"), Date.valueOf("2022-02-02"), "starci", "Published", true));
                    add(new PaperDTO("AR007", "Slimz", "Image/Article/AR007.jpg", "Mathematics", "yet", "sos", Date.valueOf("2023-02-02"), Date.valueOf("2022-02-02"), "starci", "Published", true));
                }
            }}
        };
    }

    @Test(dataProvider = "test3")
    public static void testGetPapersKeywordTopic(String username, String keyword, String topic, List<PaperDTO> papers) throws SQLException, ClassNotFoundException {
        Assert.assertEquals(PaperDAO.getPapersKeywordTopic(username, keyword, topic), papers);
    }
}
