/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package testng.core.tdd.giangvt;

import Respiratory.Article.ArticleDAO;
import Respiratory.Article.ArticleDTO;
import Respiratory.Topic.TopicDTO;
import Respiratory.Topic.TopicDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author Truong Giang
 */
public class DDTTest {

    //1. Test getArticle(String name)
    @DataProvider(name = "ArticleRepository")
    public static Object[][] articleRepo() {
        return new Object[][]{{new ArticleDTO("AR008",
            null, "Ignis",
            "starci", "Environment", "yet", "Not Yet", "Not Yet",
            null, "Public", "StarCi MATHyme", 291, 2, 0, true)
        }};
    }

    @Test(dataProvider = "ArticleRepository")
    public void getArticle(ArticleDTO expected) throws SQLException, ClassNotFoundException {
        ArticleDTO actual = ArticleDAO.getArticle("AR008");
        Assert.assertEquals(expected.getTopic(), actual.getTopic());
    }
    
    //2. Test getArticle(String name)
    @DataProvider(name = "TopicRepository")
    public Object[][] topicRepo() {
        return new Object[][]{
            {new ArrayList<TopicDTO>() {
                {
                    add(new TopicDTO("Animal", "Image/Topic/Animal.png"));
                    add(new TopicDTO("Bacteria", "Image/Topic/Bacteria.png"));
                    add(new TopicDTO("Chemistry", "Image/Topic/Chemistry.png"));
                    add(new TopicDTO("COVID-19", "Image/Topic/COVID-19.png"));
                    add(new TopicDTO("Environment", "Image/Topic/Environment.png"));
                    add(new TopicDTO("Mathematics", "Image/Topic/Mathematics.png"));
                    add(new TopicDTO("Plant", "Image/Topic/Plant.png"));
                  
                }
            }}
        };
    }

    @Test(dataProvider = "TopicRepository")
    public static void getTopics(List<TopicDTO> topics) throws SQLException, ClassNotFoundException {
        Assert.assertEquals(TopicDAO.getTopics(), topics);
    }
    public DDTTest() {
    }

}
