/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Respiratory.Topic;

import java.sql.SQLException;

/**
 *
 * @author tucuo
 */
public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
         System.out.println(TopicDAO.getTopicsUsername("starci", "flo"));
    }
}
