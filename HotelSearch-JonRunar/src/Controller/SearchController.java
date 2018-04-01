/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Notandi
 */
public class SearchController {

    /**
     *
     * @param checkBoxes
     * @param searchString
     */
    public static void search(boolean[] checkBoxes, String searchString) {
        String[] queries = {"Fotlun", "Airport", "Wi-fi", "Gonguleid", "Likamsraekt", "Morgunmatur", "Midbaer", "Spa", "Sturta", "Tv"};
                String query = "";
        for (int i = 0; i < 10; i++) {
            if (checkBoxes[i] == true) {
                query += " AND conveniences LIKE '%" + queries[i] + "%'";
            }
        }
                Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/Notandi/Documents/Skóli/Þróun Hugbúnaðar/ThrounHugbunadar/Hoteldb.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            //statement.executeUpdate("insert into table values(1,2)");
            ResultSet rs = statement.executeQuery("SELECT * from Hotel where name like '%" + searchString + "%'" + query);
            //System.out.print("SELECT * from Hotel where name like '%" + searchString + "%'" + query);
            while(rs.next()) {
                String strLine = rs.getString("conveniences");
                String[] conveniences = strLine.split(":");
                System.out.println("Hotelið heitir " + rs.getString("name"));
                System.out.println("Staðsetningin er " + rs.getString("location"));                
                for (String convenience : conveniences) {
                    System.out.println("Hótelið inniheldur: " + convenience);
                }
            }
        }
                catch(SQLException e) {
            System.err.println(e.getMessage());
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e);
          }
        }
    }
}


