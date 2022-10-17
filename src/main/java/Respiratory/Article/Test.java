
package Respiratory.Article;


import Respiratory.Paper.PaperDAO;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) 
            throws SQLException, ClassNotFoundException{
    
        
        //    for(ArticleDTO acc: SearchArticleUtils.keywordFilter("star")){
         //       System.out.print(acc.getTotalReaction());
         //   }
        System.out.println(PaperDAO.getPapersUsernameLastedModifiedDate("starci"));
    }
    
}
    
