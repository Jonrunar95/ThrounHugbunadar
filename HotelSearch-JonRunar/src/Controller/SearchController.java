/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Hotel;
import Model.Room;
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
    static Hotel[] hotel;
    static int talning = 0;
    static Room[] room;
    static int talningRoom = 0;

    /**
     *
     * @param checkBoxes
     * @param searchString
     * @return 
     */
    public static Room[] search(boolean[] checkBoxes, String searchString) {
        hotel = new Hotel[10];
        room = new Room[10];
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
            ResultSet rs = statement.executeQuery("SELECT * from Hotel where name like '%" + searchString + "%'" + query + ";");
            System.out.print("SELECT * from Hotel where name like '%" + searchString + "%'" + query);
            while(rs.next()) {
                String sid = rs.getString("id");
                System.out.println(sid);
                int id = Integer.parseInt(sid);
                String name = rs.getString("name");
                String location = rs.getString("location");
                int stars = Integer.parseInt(rs.getString("star"));
                String photoUrl = rs.getString("photo_url");
                String strLine = rs.getString("conveniences");
                String[] conveniences = strLine.split(";");
                Hotel temp = new Hotel(id, name, location, stars, photoUrl, conveniences);
                hotel[talning] = temp;
                talning++;
            }
            for(int i = 0; i<=talning; i++ ) {
                ResultSet rs2 = statement.executeQuery("SELECT * FROM Room WHERE hotelid = " + hotel[talning].getHotelId() + ";");
                while(rs2.next()) {
                    int roomId = Integer.parseInt(rs2.getString("id"));
                    int size = Integer.parseInt(rs2.getString("size"));
                    double price = Double.parseDouble(rs2.getString("price"));
                    Room temp = new Room(roomId, size, price, hotel[talning]);
                    room[talningRoom] = temp;
                    talningRoom++;
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
        return room;
    }
}


