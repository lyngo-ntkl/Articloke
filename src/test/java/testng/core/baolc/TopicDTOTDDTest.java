package testng.core.baolc;

import Respiratory.Topic.TopicDAO;
import java.sql.SQLException;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author chiba
 */
public class TopicDTOTDDTest {
    
    @Test
    public void getTopicsTest() throws SQLException, ClassNotFoundException{
       //test Topic
       String expectedTopic [] = {"Animal","Bacteria","Chemistry","COVID-19","Environment","Mathematics","Plant"};
       String expectedPic [] = {"Image/Topic/Animal.png","Image/Topic/Bacteria.png","Image/Topic/Chemistry.png","Image/Topic/COVID-19.png",
                                "Image/Topic/Environment.png","Image/Topic/Mathematics.png","Image/Topic/Plant.png"};
       String actualTopic [] = new String [7];
       String actualPic [] = new String [7];
        for (int i = 0; i < 7; i++) {
            actualTopic[i] = TopicDAO.getTopics().get(i).getTopic();
            actualPic [i] = TopicDAO.getTopics().get(i).getPicture();
        }
        Assert.assertEquals(actualTopic, expectedTopic);
        Assert.assertEquals(actualPic, expectedPic);        
    }

}
