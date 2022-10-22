package testng.core.quangvdm;
import Respiratory.Article.ArticleDAO;
import Respiratory.Article.ArticleDTO;
import java.sql.SQLException;
import org.junit.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class ArticleDAOTDDTest {

    @Test
    public void TestGetArticle() throws SQLException, ClassNotFoundException {
        ArticleDTO expected = new ArticleDTO("AR001", "Image/Article/AR001.jpg", "Florentino",
                "starci", "Mathematics", "yet", "Not Yet", "Not Yet", null, "Public",
                "FPT", (float) 143.2, 2, 1, true);
        ArticleDTO expected1 = new ArticleDTO();
        ArticleDTO actual = ArticleDAO.getArticle("AR001");
        //Assert.assertEquals(expected.getID(), actual.getID());
        //Assert.assertEquals(expected.getPublishedDate(), actual.getPublishedDate());
        Assert.assertEquals(expected, actual);
    }

}