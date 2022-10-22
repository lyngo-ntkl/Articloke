package testng.core.tdd.giangvt;

import Respiratiory.Reaction.ReactionDAO;
import Respiratory.Article.ArticleDAO;
import Respiratory.Article.ArticleDTO;
import Respiratory.Paper.PaperDAO;
import Respiratory.Topic.TopicDAO;
import Respiratory.User.UserDTO;

import java.sql.SQLException;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Truong Giang
 */
public class TDDTest {

    //1. Test getPapersKeyword() inside PaperDAO.java
    @Test
    public void getPapersKeyword() throws SQLException, ClassNotFoundException {
        //TEST CASE #1 : expected = 1 array list with 9 elements, actual will return 9 elements too  
        // test getPaperKeyword(username_,keyword) when enter username : "starci" and keyword :"yet" inside PaperDAO
        // compare Title
        String[] expected = {"Florentino", "Kahlii", "Preyta", "Zata", "Tarra", "Paine", "Slimz", "Ignis", "Kirito"};
        String[] actual = new String[9];
        for (int i = 0; i < 9; i++) {
            actual[i] = PaperDAO.getPapersKeyword("starci", "yet").get(i).getTitle();
        }
        Assert.assertEquals(actual, expected);
        //TEST CASE #2 : expected = 1 array list with 9 elements, actual will return 9 elements too  
        // test getPaperKeyword(username_,keyword) when enter username : "starci" and keyword :"yet" inside PaperDAO
        // compare Topic
        String[] expected1 = {"Mathematics", "Mathematics", "Mathematics", "Mathematics", "Mathematics", "Mathematics", "Mathematics", "Environment", "Environment"};
        String[] actual1 = new String[9];
        for (int i = 0; i < 9; i++) {
            actual1[i] = PaperDAO.getPapersKeyword("starci", "yet").get(i).getTopic();
        }
        Assert.assertEquals(actual1, expected1);
        
    }

    //2. Test getTopics() inside TopicDAO.java
    @Test
    public void getTopics() throws SQLException, ClassNotFoundException {
        //TEST CASE #1 : expected = 1 array list with 7 elements, actual will return 7 elements too  
        // test getTopics() and compare 7 elements with each others.
        // compare Topic
        String[] expected = {"Animal", "Bacteria", "Chemistry", "COVID-19", "Environment", "Mathematics", "Plant"};
        String[] actual = new String[7];
        for (int i = 0; i < 7; i++) {
            actual[i] = TopicDAO.getTopics().get(i).getTopic();
        }
        Assert.assertEquals(actual, expected);
        //TEST CASE #2 : expected = 1 array list with 7 elements, actual will return 7 elements too  
        // test getTopics() and compare 7 elements with each others.
        // compare Picture
        String[] expected1 = {"Image/Topic/Animal.png", "Image/Topic/Bacteria.png", "Image/Topic/Chemistry.png", "Image/Topic/COVID-19.png", "Image/Topic/Environment.png", "Image/Topic/Mathematics.png", "Image/Topic/Plant.png"};
        String[] actual1 = new String[7];
        for (int i = 0; i < 7; i++) {
            actual1[i] = TopicDAO.getTopics().get(i).getPicture();
        }
        Assert.assertEquals(actual1, expected1);

    }
    
    //3. Test getArticle(String ID) inside ArticalDAO.java
    @Test
    public void getArticle() throws SQLException, ClassNotFoundException {
        //TEST CASE #1 : expected = 1  list in ArticleDTO, actual will return 1 list elements same with expected.
        // compare Topic between expected and actual
        ArticleDTO expected = new ArticleDTO("AR008",
                null, "Ignis",
                "starci", "Environment", "yet", "Not Yet", "Not Yet",
                 null, "Public", "StarCi MATHyme", 291, 2, 0, true);
        ArticleDTO actual = ArticleDAO.getArticle("AR008");
        Assert.assertEquals(expected.getTopic(), actual.getTopic());
        
        //TEST CASE #2 : expected = 1  list in ArticleDTO, actual will return 1 list elements same with expected.
        // compare Description between expected and actual
        ArticleDTO expected1 = new ArticleDTO("AR008",
                null, "Ignis",
                "starci", "Environment", "yet", "Not Yet", "Not Yet",
                 null, "Public", "StarCi MATHyme", 291, 2, 0, true);
        // actual
        ArticleDTO actual1 = ArticleDAO.getArticle("AR008");

        Assert.assertEquals(expected1.getDescription(), actual1.getDescription());
    }
    
    //4. Test getTotalReaction(String username) inside ReactionDAO.java
    @Test
    public void getTotalReaction() throws SQLException, ClassNotFoundException{
        int expected = 18;
        int actual = ReactionDAO.getTotalReaction("starci");
        Assert.assertEquals(actual, expected);
    }
    public TDDTest() {
    }

}
