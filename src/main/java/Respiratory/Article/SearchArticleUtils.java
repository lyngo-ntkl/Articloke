    package Respiratory.Article;

import Support.DatabaseConnector;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SearchArticleUtils implements Serializable {

    public static List<ArticleDTO> keywordFilter(String keyword) throws SQLException, ClassNotFoundException {
        String SQL = "SELECT cuong.ID, picture, title, username, topic, description, link, linkDemo, publishedDate, permission,\n"
                + "organization, price, totalReaction,totalDownload, cuong.status FROM\n"
                + "(SELECT chidori.ID, totalReaction, totalDownload FROM \n"
                + "(SELECT ar.ID, COUNT(it.ID) as totalReaction\n"
                + "FROM Paper pp inner join Article ar ON pp.ID = ar.ID\n"
                + "left join Reaction it ON ar.ID = it.ID \n"
                + "WHERE title LIKE ? OR pp.username LIKE ?\n"
                + "OR description LIKE ? GROUP BY ar.ID) chidori INNER JOIN\n"
                + "(SELECT ar.ID, COUNT(downloadedDate) as totalDownload\n"
                + "FROM Paper pp inner join Article ar ON pp.ID = ar.ID\n"
                + "left join Download dl ON ar.ID = dl.ID GROUP BY ar.ID\n"
                + ") kakashi ON chidori.ID = kakashi.ID\n"
                + ") starci inner join\n"
                + "(SELECT ar.ID, picture, title, username, topic, description, link, linkDemo, publishedDate, permission, organization, price, ar.status FROM Article ar inner join Paper pp ON ar.ID = pp.ID) cuong\n"
                + "ON starci.ID = cuong.ID";
        List<ArticleDTO> articles = null;
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        try {
            con = DatabaseConnector.makeConnection();
            if (con != null) {
                pre = con.prepareStatement(SQL);
                pre.setString(1, "%" + keyword + "%");
                pre.setString(2, "%" + keyword + "%");
                pre.setString(3, "%" + keyword + "%");

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
                    String organization = res.getString("organization");
                    float price = res.getFloat("price");
                    int totalReaction = res.getInt("totalReaction");
                    int totalDownload = res.getInt("totalDownload");
                    boolean status = res.getBoolean("status");

                    ArticleDTO article = new ArticleDTO(ID, picture, title, username, topic, description, link, linkDemo, publishedDate, permission, organization, price, totalReaction, totalDownload, status);
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

    public static List<ArticleDTO> titleAuthorFiler(String title, String author, List<ArticleDTO> articles) {
        List<ArticleDTO> articlesAfterFilting = null;
        if (articles != null) {
            for (ArticleDTO ar : articles) {
                if (ar.getTitle().toLowerCase().contains(title.toLowerCase()) && ar.getUsername().toLowerCase().contains(author.toLowerCase())) {
                    if (articlesAfterFilting == null) {
                        articlesAfterFilting = new ArrayList<>();
                    }
                    articlesAfterFilting.add(ar);

                }
            }
        }
        return articlesAfterFilting;

    }

    public static List<ArticleDTO> topicFilter(String topic, List<ArticleDTO> articles) {
        List<ArticleDTO> articlesAfterFilting = null;
        if (articles != null) {
            if (topic.equals("All")) {
                articlesAfterFilting = articles;
            } else {
                for (ArticleDTO ar : articles) {
                    if (ar.getTopic().equals(topic)) {
                        if (articlesAfterFilting == null) {
                            articlesAfterFilting = new ArrayList<>();
                        }
                        articlesAfterFilting.add(ar);

                    }
                }
            }

        }
        return articlesAfterFilting;
    }

    public static List<ArticleDTO> permissionFilter(String organization, String permission, List<ArticleDTO> articles) {
        List<ArticleDTO> articlesAfterFilting = new ArrayList<>();
        if (articles != null) {
            if (permission.equals("All")) {
                for (ArticleDTO ar : articles) {
                    if (ar.getPermission().equals("Public")) {

                        articlesAfterFilting.add(ar);
                    }
                }

                for (ArticleDTO ar : articles) {
                    if (ar.getPermission().equals("For Organization") || ar.getPermission().equals("Private")) {
                        if (ar.getOrganization().equals(organization)) {

                            articlesAfterFilting.add(ar);
                        }

                    }
                }
            } else if (permission.equals("Public")) {
                for (ArticleDTO ar : articles) {
                    if (ar.getPermission().equals("Public")) {

                        articlesAfterFilting.add(ar);
                    }
                }
            } else if (permission.equals("For Organization")) {
                for (ArticleDTO ar : articles) {
                    if (ar.getPermission().equals("For Organization")) {
                        if (ar.getOrganization().equals(organization)) {
                            articlesAfterFilting.add(ar);
                        }

                    }
                }
            } else {
                for (ArticleDTO ar : articles) {
                    if (ar.getPermission().equals("Private")) {
                        if (ar.getOrganization().equals(organization)) {

                            articlesAfterFilting.add(ar);
                        }

                    }
                }
            }

        }
        return articlesAfterFilting;

    }

    public static List<ArticleDTO> sortedByFilter(String sortedBy, List<ArticleDTO> articles) {
        List<ArticleDTO> articlesAfterFilting = articles;
        if (sortedBy.equals("Alphabet")) {
            Collections.sort(articlesAfterFilting, new Comparator<ArticleDTO>() {
                @Override
                public int compare(ArticleDTO a1, ArticleDTO a2) {
                    if (a1.getTitle().compareTo(a2.getTitle()) > 0) {
                        return 1;
                    } else {
                        if (a1.getTitle().equals(a2.getTitle())) {
                            return 0;
                        } else {
                            return -1;
                        }
                    }
                }
            });
        } else if (sortedBy.equals("Published Date")) {
            Collections.sort(articlesAfterFilting, new Comparator<ArticleDTO>() {
                @Override
                public int compare(ArticleDTO a1, ArticleDTO a2) {
                    if (a2.getPublishedDate().compareTo(a1.getPublishedDate()) < 0) {
                        return 1;
                    } else {
                        if (a1.getPublishedDate().equals(a2.getPublishedDate())) {
                            return 0;
                        } else {
                            return -1;
                        }
                    }
                }
            });

        }
        return articlesAfterFilting;
    }
}
