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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Notandi
 */
public class DatabaseController {
    
    public static ArrayList<Hotel> createHotels(String searchString, String query) {
        ArrayList<Hotel> hotel = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/Notandi/Documents/Skóli/Þróun Hugbúnaðar/ThrounHugbunadar/Hoteldb.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            String q = "SELECT * from Hotel where location like '%" + searchString + "%'" + query;
            System.out.println(q);
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
        } catch(SQLException e) {
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
        return hotel;
    }

    public static ArrayList<Room> createRooms(ArrayList<Hotel> hotel, int size, Boolean tvibreitt, int price1, int price2, int stars) {
        ArrayList<Room> room = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/Notandi/Documents/Skóli/Þróun Hugbúnaðar/ThrounHugbunadar/Hoteldb.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            for(int i = 0; i<hotel.size(); i++ ) { 
                int query = hotel.get(i).getHotelId();
                String q = "SELECT * FROM Room WHERE hotelId = " + query;
                ResultSet rs = statement.executeQuery(q);
                while(rs.next()) {
                    String intRoomId = rs.getString("id");
                    int roomId = Integer.parseInt(intRoomId);
                    int roomSize = Integer.parseInt(rs.getString("size"));
                    boolean roomTvibreitt = rs.getBoolean("tvibreitt");
                    double roomPrice = Double.parseDouble(rs.getString("price"));
                    if(size == roomSize && tvibreitt == roomTvibreitt && roomPrice >= price1 && roomPrice < price2) {
                        Room temp = new Room(roomId, roomSize, roomTvibreitt, roomPrice, hotel.get(i));
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
        return room;
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
    
    static boolean isDateReserved(ArrayList<Date> dates, int roomId) {
        Connection connection = null;
        boolean isReserved = true;
        try {
            connection =  DriverManager.getConnection("jdbc:sqlite:C:/Users/Notandi/Documents/Skóli/Þróun Hugbúnaðar/ThrounHugbunadar/Hoteldb.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            for(int i = 0; i<dates.size(); i++) {
                String reserved = "SELECT * from Reservation where roomId = '" + roomId + "'" + " AND DATE = '" + dates.get(i) + "'";
                ResultSet rs = statement.executeQuery(reserved);
                while(rs.next()) {
                    isReserved = false;
                }
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
        return isReserved;
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
