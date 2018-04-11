/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Hotel;
import Model.Room;
import View.LoginForm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Notandi
 */
public class DatabaseController {


    static ArrayList<Hotel> hotel;
    static ArrayList<Room> room;
    
        public static ArrayList<Hotel> getHotel() {
        return hotel;
    }

    public static ArrayList<Room> getRoom() {
        return room;
    }

    public static void createRooms(String searchString, String query, boolean tvibreitt) {
        hotel = new ArrayList<>();
        room = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/Notandi/Documents/Skóli/Þróun Hugbúnaðar/ThrounHugbunadar/Hoteldb.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            String q = "SELECT * from Hotel where name like '%" + searchString + "%'" + query;
            ResultSet rs = statement.executeQuery(q);
            while(rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String location = rs.getString("location");
                
                String photoUrl = rs.getString("photo_url");
                String strLine = rs.getString("conveniences");
                String[] conveniences = strLine.split(";");
                int stars = Integer.parseInt(rs.getString("stars"));
                int intid = Integer.parseInt(id);
                Hotel temp = new Hotel(intid, name, location, stars, photoUrl, conveniences);
                hotel.add(temp);
            }

            for(int i = 0; i<hotel.size(); i++ ) {
                System.out.println("Fjöldi Hótela: " + hotel.size());
                System.out.println("Nafn á Hóteli: " + hotel.get(0).getName());
                System.out.println("Stjörnur: " + hotel.get(0).getStars());
                System.out.println("Hotel id: " + hotel.get(0).getHotelId());
                
                int query2 = hotel.get(i).getHotelId();
                String q2 = "SELECT * FROM Room WHERE hotelId = " + query2;
                ResultSet rs2 = statement.executeQuery(q2);
                while(rs2.next()) {
                    String intRoomId = rs2.getString("id");
                    int roomId = Integer.parseInt(intRoomId);
                    int size = Integer.parseInt(rs2.getString("size"));
                    boolean tvibreittRum = rs2.getBoolean("tvibreitt");
                    double price = Double.parseDouble(rs2.getString("price"));
                    if(tvibreittRum == tvibreitt) {
                        Room temp = new Room(roomId, size, price, hotel.get(i));
                        room.add(temp);
                    }
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

    static String getUsernames(String username) {
        String s = "";
        Connection connection = null;
        try {
            connection =  DriverManager.getConnection("jdbc:sqlite:C:/Users/Notandi/Documents/Skóli/Þróun Hugbúnaðar/ThrounHugbunadar/Hoteldb.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            String searchForUser = "SELECT * from User where name = '" + username + "'";
            ResultSet rs = statement.executeQuery(searchForUser);
            while(rs.next()) {
                s = rs.getString("username");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
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
        return s;
    }

    static int registerDatabase(String query) {
        int executeUpdate = 0;
        try {
            Connection connection =  DriverManager.getConnection("jdbc:sqlite:C:/Users/Notandi/Documents/Skóli/Þróun Hugbúnaðar/ThrounHugbunadar/Hoteldb.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            executeUpdate = statement.executeUpdate(query);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        return executeUpdate;
    }

    static int loginDatabase(String username, String password) {
        Connection connection = null;
        int log = 1;
        try {    
            connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/Notandi/Documents/Skóli/Þróun Hugbúnaðar/ThrounHugbunadar/Hoteldb.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            ResultSet rs = statement.executeQuery("SELECT * from User WHERE username = '" + username + "' AND password = '" + password + "'");
            while (rs.next()) {
                log = 0;
            }
        } catch (SQLException ex) { 
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
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
        return log;
    }
}
