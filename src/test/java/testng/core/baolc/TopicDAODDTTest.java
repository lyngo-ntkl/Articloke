package testng.core.baolc;

import Respiratory.Topic.TopicDAO;
import Respiratory.Topic.TopicDTO;
import Respiratory.Topic.TopicPlusArticleCount;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;

/**
 *
 * @author chiba
 */
public class TopicDAODDTTest {

    //Test getTopics
//    @DataProvider(name = "topic")
//    public Object[][] topicStatic() {
//        return new Object[][]{
//            new Object[]{"Animal","Image/Topic/Animal.png"},
//            new Object[]{"Bacteria","Image/Topic/Bacteria.png"},
//            new Object[]{"Chemistry","Image/Topic/Chemistry.png"},
//            new Object[]{"COVID-19","Image/Topic/COVID-19.png"},
//            new Object[]{"Environment","Image/Topic/Environment.png"},
//            new Object[]{"Mathematics","Image/Topic/Mathematics.png"},
//            new Object[]{"Plant","Image/Topic/Plant.png"}
//        };
//    }
//
//    @Test(dataProvider = "topic")
//    public void getTopicsMostCountTest(String topicExpect, String imgExpect) throws SQLException, ClassNotFoundException {
//        List<TopicDTO> actual = TopicDAO.getTopics();
//        List<TopicDTO> expected = new ArrayList<>();
//        for (int i = 0; i < 7; i++) {
//            String topic = topicExpect;
//            String picture = imgExpect;
//
//            TopicDTO topicObject = new TopicDTO(topic, picture);
//            expected.add(topicObject);
//        }
//        Assert.assertEquals(expected, actual);
//    }     
        
    //Test TopicsMostCountTest
    @DataProvider(name = "topic")
    public Object[][] topicStatic() {
        return new Object[][]{
            new Object[]{"Mathematics", "Image/Topic/Mathematics.png", 7},
            new Object[]{"Environment", "Image/Topic/Environment.png", 2},
            new Object[]{"Plant", "Image/Topic/Plant.png", 0},
            new Object[]{"Animal", "Image/Topic/Animal.png", 0},
            new Object[]{"Bacteria", "Image/Topic/Bacteria.png", 0},
            new Object[]{"Chemistry", "Image/Topic/Chemistry.png", 0},
            new Object[]{"COVID-19", "Image/Topic/COVID-19.png", 0}
        };
    }

    @Test(dataProvider = "topic")
    public void getTopicsMostCountTest(String topicExpect, String imgExpect, int MostCount) throws SQLException, ClassNotFoundException {
        List<TopicPlusArticleCount> actual = TopicDAO.getTopicsMostCount();
        List<TopicPlusArticleCount> expected = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            String topic = topicExpect;
            String picture = imgExpect;
            int count = MostCount;

            TopicDTO topicObject = new TopicDTO(topic, picture);
            TopicPlusArticleCount element = new TopicPlusArticleCount(topicObject, count);
            expected.add(element);
        }
        Assert.assertEquals(expected, actual);
    }

}