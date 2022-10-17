package Respiratory.Article;

import Respiratory.Paper.PaperDTO;
import Support.DatabaseConnector;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO implements Serializable {

    public static List<ArticleDTO> getArticlesKeywordTopic(String username_, String keyword, String currentTopic) throws SQLException, ClassNotFoundException {
        String SQL = " SELECT tu.ID, picture, title, username, topic, description, link, linkDemo,\n"
                + "  publishedDate, permission, organization, price, totalReaction, totalDownload, tu.status \n"
                + "  FROM\n"
                + "  (SELECT chidori.ID, totalReaction, totalDownload FROM \n"
                + "(SELECT ar.ID, COUNT(it.ID) as totalReaction\n"
                + "FROM Paper pp inner join Article ar ON pp.ID = ar.ID\n"
                + "left join Reaction it ON ar.ID = it.ID \n"
                + "WHERE pp.username = ?\n AND (pp.title like ? OR pp.description like ? OR ar.ID like ?) AND pp.topic = ? \n"
                + "GROUP BY ar.ID\n"
                + ") chidori INNER JOIN\n"
                + "(SELECT ar.ID, COUNT(downloadedDate) as totalDownload\n"
                + "FROM Paper pp inner join Article ar ON pp.ID = ar.ID\n"
                + "left join Download dl ON ar.ID = dl.ID GROUP BY ar.ID\n"
                + ") kakashi ON chidori.ID = kakashi.ID) cuong\n"
                + "			 inner join (SELECT ar.ID, picture, title, username, topic, description, link, linkDemo, \n"
                + "			 publishedDate, permission, organization, price, ar.status FROM Article ar inner join Paper pp ON ar.ID = pp.ID)\n"
                + "			 tu ON cuong.ID = tu.ID";
        List<ArticleDTO> articles = null;
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        try {
            con = DatabaseConnector.makeConnection();
            if (con != null) {
                if (currentTopic.equals("All")) {
                    SQL = "SELECT tu.ID, picture, title, username, topic, description, link, linkDemo,\n"
                            + "  publishedDate, permission, organization, price, totalReaction, totalDownload, tu.status \n"
                            + "  FROM\n"
                            + "  (SELECT chidori.ID, totalReaction, totalDownload FROM \n"
                            + "(SELECT ar.ID, COUNT(it.ID) as totalReaction\n"
                            + "FROM Paper pp inner join Article ar ON pp.ID = ar.ID\n"
                            + "left join Reaction it ON ar.ID = it.ID \n"
                            + "WHERE pp.username = ?\n AND (pp.title like ? OR pp.description like ? OR ar.ID like ?) \n"
                            + "GROUP BY ar.ID\n"
                            + ") chidori INNER JOIN\n"
                            + "(SELECT ar.ID, COUNT(downloadedDate) as totalDownload\n"
                            + "FROM Paper pp inner join Article ar ON pp.ID = ar.ID\n"
                            + "left join Download dl ON ar.ID = dl.ID GROUP BY ar.ID\n"
                            + ") kakashi ON chidori.ID = kakashi.ID) cuong\n"
                            + "			 inner join (SELECT ar.ID, picture, title, username, topic, description, link, linkDemo, \n"
                            + "			 publishedDate, permission, organization, price, ar.status FROM Article ar inner join Paper pp ON ar.ID = pp.ID)\n"
                            + "			 tu ON cuong.ID = tu.ID";
                    pre = con.prepareStatement(SQL);
                    pre.setString(1, username_);
                    pre.setString(2, "%" + keyword + "%");
                    pre.setString(3, "%" + keyword + "%");
                    pre.setString(4, "%" + keyword + "%");
                } else {
                    pre = con.prepareStatement(SQL);
                    pre.setString(1, username_);
                    pre.setString(2, "%" + keyword + "%");
                    pre.setString(3, "%" + keyword + "%");
                    pre.setString(4, "%" + keyword + "%");
                    pre.setString(5, currentTopic);
                }
                res = pre.executeQuery();

                while (res.next()) {
                    String ID = res.getString("ID");
                    String picture = res.getString("picture");
                    String title = res.getString("title");
                    String username = res.getString("username");
                    String topic = res.getString("topic");
                    String description = res.getString("description");

                    String link = res.getString("link");
                    String linkDemo = res.getString("linkDemo");
                    Date publishedDate = res.getDate("publishedDate");
                    String permission = res.getString("permission");
                    String organzation = res.getString("organization");
                    float price = res.getFloat("price");
                    int totalReaction = res.getInt("totalReaction");
                    int totalDownload = res.getInt("totalDownload");
                    boolean status = res.getBoolean("status");

                    ArticleDTO article = new ArticleDTO(ID, picture, title, username, topic, description, link, linkDemo, publishedDate, permission, organzation, price, totalReaction, totalDownload, status);
                    if (articles == null) {
                        articles = new ArrayList<>();
                    }
                    articles.add(article);
                }
            }
        } finally {
            if (con != null) {
                con.close();
            }

            if (pre != null) {
                pre.close();
            }

            if (res != null) {
                res.close();
            }

        }
        return articles;
    }

    public static List<ArticleDTO> getArticlesSearch(String keyword, String title, String author, String topic, String organization, String permission, String sortedBy)
            throws SQLException, ClassNotFoundException {

        List<ArticleDTO> list = SearchArticleUtils.keywordFilter(keyword);
        List<ArticleDTO> list2 = SearchArticleUtils.titleAuthorFiler(title, author, list);
        List<ArticleDTO> list3 = SearchArticleUtils.topicFilter(topic, list2);
        List<ArticleDTO> list4 = SearchArticleUtils.permissionFilter(organization, permission, list3);
        List<ArticleDTO> list5 = SearchArticleUtils.sortedByFilter(sortedBy, list4);
        return list5;

    }

    public static List<ArticleDTO> getArticlesUsernameLatestDate(String username_) throws SQLException, ClassNotFoundException {
        String SQL = " SELECT tu.ID, picture, title, username, topic, description, link, linkDemo,\n"
                + "  publishedDate, permission, organization, price, totalReaction, totalDownload, tu.status \n"
                + "  FROM\n"
                + "  (SELECT chidori.ID, totalReaction, totalDownload FROM \n"
                + "(SELECT ar.ID, COUNT(it.ID) as totalReaction\n"
                + "FROM Paper pp inner join Article ar ON pp.ID = ar.ID\n"
                + "left join Reaction it ON ar.ID = it.ID \n"
                + "WHERE pp.username = ?\n"
                + "GROUP BY ar.ID\n"
                + ") chidori INNER JOIN\n"
                + "(SELECT ar.ID, COUNT(downloadedDate) as totalDownload\n"
                + "FROM Paper pp inner join Article ar ON pp.ID = ar.ID\n"
                + "left join Download dl ON ar.ID = dl.ID GROUP BY ar.ID\n"
                + ") kakashi ON chidori.ID = kakashi.ID) cuong\n"
                + "			 inner join (SELECT ar.ID, picture, title, username, topic, description, link, linkDemo, \n"
                + "			 publishedDate, permission, organization, price, ar.status FROM Article ar inner join Paper pp ON ar.ID = pp.ID)\n"
                + "			 tu ON cuong.ID = tu.ID\n"
                + "			 ORDER BY publishedDate DESC";
        List<ArticleDTO> articles = null;
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        try {
            con = DatabaseConnector.makeConnection();
            if (con != null) {

                pre = con.prepareStatement(SQL);
                pre.setString(1, username_);
                res = pre.executeQuery();

                while (res.next()) {
                    String ID = res.getString("ID");
                    String picture = res.getString("picture");
                    String title = res.getString("title");
                    String username = res.getString("username");
                    String topic = res.getString("topic");
                    String description = res.getString("description");

                    String link = res.getString("link");
                    String linkDemo = res.getString("linkDemo");
                    Date publishedDate = res.getDate("publishedDate");
                    String permission = res.getString("permission");
                    String organzation = res.getString("organization");
                    float price = res.getFloat("price");
                    int totalReaction = res.getInt("totalReaction");
                    int totalDownload = res.getInt("totalDownload");
                    boolean status = res.getBoolean("status");

                    ArticleDTO article = new ArticleDTO(ID, picture, title, username, topic, description, link, linkDemo, publishedDate, permission, organzation, price, totalReaction, totalDownload, status);
                    if (articles == null) {
                        articles = new ArrayList<>();
                    }
                    articles.add(article);
                }
            }
        } finally {
            if (con != null) {
                con.close();
            }

            if (pre != null) {
                pre.close();
            }

            if (res != null) {
                res.close();
            }

        }
        return articles;
    }

    public static List<ArticleDTO> getArticlesLastedPublishDate() throws SQLException, ClassNotFoundException {
        String SQL = "SELECT tu.ID, picture, title, username, topic, description, link, linkDemo,\n"
                + "  publishedDate, permission, organization, price, totalReaction, totalDownload, tu.status \n"
                + "  FROM\n"
                + "  (SELECT chidori.ID, totalReaction, totalDownload FROM \n"
                + "(SELECT ar.ID, COUNT(it.ID) as totalReaction\n"
                + "FROM Paper pp inner join Article ar ON pp.ID = ar.ID\n"
                + "left join Reaction it ON ar.ID = it.ID \n"
                + "GROUP BY ar.ID\n"
                + ") chidori INNER JOIN\n"
                + "(SELECT ar.ID, COUNT(downloadedDate) as totalDownload\n"
                + "FROM Paper pp inner join Article ar ON pp.ID = ar.ID\n"
                + "left join Download dl ON ar.ID = dl.ID GROUP BY ar.ID\n"
                + ") kakashi ON chidori.ID = kakashi.ID) cuong\n"
                + "			 inner join (SELECT ar.ID, picture, title, username, topic, description, link, linkDemo, \n"
                + "			 publishedDate, permission, organization, price, ar.status FROM Article ar inner join Paper pp ON ar.ID = pp.ID)\n"
                + "			 tu ON cuong.ID = tu.ID\n"
                + "			 ORDER BY publishedDate DESC";
        List<ArticleDTO> articles = null;
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        try {
            con = DatabaseConnector.makeConnection();
            if (con != null) {
                pre = con.prepareStatement(SQL);
                res = pre.executeQuery();
                while (res.next()) {
                    String ID = res.getString("ID");
                    String picture = res.getString("picture");
                    String title = res.getString("title");
                    String username = res.getString("username");
                    String topic = res.getString("topic");
                    String description = res.getString("description");

                    String link = res.getString("link");
                    String linkDemo = res.getString("linkDemo");
                    Date publishedDate = res.getDate("publishedDate");
                    String permission = res.getString("permission");
                    String organzation = res.getString("organization");
                    float price = res.getFloat("price");
                    int totalReaction = res.getInt("totalReaction");
                    int totalDownload = res.getInt("totalDownload");
                    boolean status = res.getBoolean("status");

                    ArticleDTO article = new ArticleDTO(ID, picture, title, username, topic, description, link, linkDemo, publishedDate, permission, organzation, price, totalReaction, totalDownload, status);
                    if (articles == null) {
                        articles = new ArrayList<>();
                    }
                    articles.add(article);
                }
            }
        } finally {
            if (con != null) {
                con.close();
            }

            if (pre != null) {
                pre.close();
            }

            if (res != null) {
                res.close();
            }

        }
        return articles;
    }

    public static ArticleDTO getArticle(String ID) throws SQLException, ClassNotFoundException {
        String SQL = "SELECT tu.ID, picture, title, username, topic, description, link, linkDemo,\n"
                + "             publishedDate, permission, organization, price, totalReaction, totalDownload, tu.status \n"
                + "               FROM\n"
                + "               (SELECT chidori.ID, totalReaction, totalDownload FROM\n"
                + "             (SELECT ar.ID, COUNT(it.ID) as totalReaction\n"
                + "              FROM Paper pp inner join Article ar ON pp.ID = ar.ID\n"
                + "              left join Reaction it ON ar.ID = it.ID \n"
                + "                WHERE ar.ID = ?\n"
                + "			 GROUP BY ar.ID\n"
                + "			\n"
                + "              ) chidori INNER JOIN\n"
                + "               (SELECT ar.ID, COUNT(downloadedDate) as totalDownload\n"
                + "             FROM Paper pp inner join Article ar ON pp.ID = ar.ID\n"
                + "           left join Download dl ON ar.ID = dl.ID GROUP BY ar.ID\n"
                + "              ) kakashi ON chidori.ID = kakashi.ID) cuong\n"
                + "               		 inner join (SELECT ar.ID, picture, title, username, topic, description, link, linkDemo,\n"
                + "               			 publishedDate, permission, organization, price, ar.status FROM Article ar inner join Paper pp ON ar.ID = pp.ID)\n"
                + "              		 tu ON cuong.ID = tu.ID";
        ArticleDTO article = null;
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        try {
            con = DatabaseConnector.makeConnection();
            if (con != null) {
                pre = con.prepareStatement(SQL);
                pre.setString(1, ID);
                res = pre.executeQuery();
                while (res.next()) {
                    String picture = res.getString("picture");
                    String title = res.getString("title");
                    String username = res.getString("username");
                    String topic = res.getString("topic");
                    String description = res.getString("description");

                    String link = res.getString("link");
                    String linkDemo = res.getString("linkDemo");
                    Date publishedDate = res.getDate("publishedDate");
                    String permission = res.getString("permission");
                    String organzation = res.getString("organization");
                    float price = res.getFloat("price");
                    int totalReaction = res.getInt("totalReaction");
                    int totalDownload = res.getInt("totalDownload");
                    boolean status = res.getBoolean("status");

                    article = new ArticleDTO(ID, picture, title, username, topic, description, link, linkDemo, publishedDate, permission, organzation, price, totalReaction, totalDownload, status);
                }
            }
        } finally {
            if (con != null) {
                con.close();
            }

            if (pre != null) {
                pre.close();
            }

            if (res != null) {
                res.close();
            }

        }
        return article;
    }
}
