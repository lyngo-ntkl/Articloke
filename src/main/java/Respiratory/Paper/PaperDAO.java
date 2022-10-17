package Respiratory.Paper;

import Support.DatabaseConnector;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaperDAO implements Serializable {

    public static List<PaperDTO> getPapersUsernameLastedModifiedDate(String username_) throws SQLException, ClassNotFoundException {
        String SQL = "SELECT * FROM Paper WHERE username = ? ORDER BY modifiedDate DESC";

        Connection con = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        List<PaperDTO> papers = null;
        try {
            con = DatabaseConnector.makeConnection();
            if (con != null) {
                pre = con.prepareStatement(SQL);
                pre.setString(1, username_);
                res = pre.executeQuery();
                while (res.next()) {
                    String ID = res.getString("ID");
                    String title = res.getString("title");
                    String picture = res.getString("picture");
                    String topic = res.getString("topic");
                    String description = res.getString("description");
                    String content = res.getString("content");
                    Date createdDate = res.getDate("createdDate");
                    Date modifiedDate = res.getDate("modifiedDate");
                    String username = res.getString("username");
                    String publishedStatus = res.getString("publishedStatus");

                    boolean status = res.getBoolean("status");

                    PaperDTO paper = new PaperDTO(ID, title, picture, topic, description, content, createdDate, modifiedDate, username, publishedStatus, status);
                    if (papers == null) {
                        papers = new ArrayList<>();
                    }
                    papers.add(paper);
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
        return papers;

    }

    public static List<PaperDTO> getPapersKeyword(String username_, String keyword) throws SQLException, ClassNotFoundException {
        String SQL = "SELECT * FROM Paper\n"
                + "WHERE username = ? AND\n"
                + "(ID like ? OR Description like ?\n"
                + "OR title like ?) ";

        Connection con = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        List<PaperDTO> papers = null;
        try {
            con = DatabaseConnector.makeConnection();
            if (con != null) {
                pre = con.prepareStatement(SQL);
                pre.setString(1, username_);
                pre.setString(2, "%" + keyword + "%");
                pre.setString(3, "%" + keyword + "%");
                pre.setString(4, "%" + keyword + "%");

                res = pre.executeQuery();
                while (res.next()) {
                    String ID = res.getString("ID");
                    String title = res.getString("title");
                    String picture = res.getString("picture");
                    String topic = res.getString("topic");
                    String description = res.getString("description");
                    String content = res.getString("content");
                    Date createdDate = res.getDate("createdDate");
                    Date modifiedDate = res.getDate("modifiedDate");
                    String username = res.getString("username");
                    String publishedStatus = res.getString("publishedStatus");

                    boolean status = res.getBoolean("status");

                    PaperDTO paper = new PaperDTO(ID, title, picture, topic, description, content, createdDate, modifiedDate, username, publishedStatus, status);
                    if (papers == null) {
                        papers = new ArrayList<>();
                    }
                    papers.add(paper);
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
        return papers;

    }

    public static List<PaperDTO> getPapersKeywordTopic(String username_, String keyword, String topic_) throws SQLException, ClassNotFoundException {
        String SQL = "SELECT * FROM Paper\n"
                + "WHERE username = ? AND topic = ? AND\n"
                + "(ID like ? OR Description like ?\n"
                + "OR title like ?) ";

        Connection con = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        List<PaperDTO> papers = null;
        try {

            con = DatabaseConnector.makeConnection();
            if (con != null) {

                if (!topic_.equals("All")) {

                    pre = con.prepareStatement(SQL);
                    pre.setString(1, username_);
                    pre.setString(2, topic_);
                    pre.setString(3, "%" + keyword + "%");
                    pre.setString(4, "%" + keyword + "%");
                    pre.setString(5, "%" + keyword + "%");

                } else {
                    SQL = "SELECT * FROM Paper\n"
                            + "WHERE username = ? AND\n"
                            + "(ID like ? OR Description like ?\n"
                            + "OR title like ?) ";
                    pre = con.prepareStatement(SQL);
                    pre.setString(1, username_);
                    pre.setString(2, "%" + keyword + "%");
                    pre.setString(3, "%" + keyword + "%");
                    pre.setString(4, "%" + keyword + "%");
                }
                res = pre.executeQuery();
                while (res.next()) {
                    String ID = res.getString("ID");
                    String title = res.getString("title");
                    String picture = res.getString("picture");
                    String topic = res.getString("topic");
                    String description = res.getString("description");
                    String content = res.getString("content");
                    Date createdDate = res.getDate("createdDate");
                    Date modifiedDate = res.getDate("modifiedDate");
                    String username = res.getString("username");
                    String publishedStatus = res.getString("publishedStatus");

                    boolean status = res.getBoolean("status");

                    PaperDTO paper = new PaperDTO(ID, title, picture, topic, description, content, createdDate, modifiedDate, username, publishedStatus, status);
                    if (papers == null) {
                        papers = new ArrayList<>();
                    }
                    papers.add(paper);
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
        return papers;

    }

}
