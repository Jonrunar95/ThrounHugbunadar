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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    public static final String DB_URL = "jdbc:sqlite:C:/Users/Notandi/Documents/Skóli/Þróun Hugbúnaðar/ThrounHugbunadar/Hoteldb.db";

    /**
     *
     * @param searchString
     * @param query
     * @return
     */
    public static ArrayList<Hotel> createHotels(String searchString, String query) {
        ArrayList<Hotel> hotel = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL);
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
            String conv ="";
            if(size != 0) {
                conv = " AND Start = " + size;
            }
            if (tvibreitt == true) {
                conv = "AND tvibreitt = true";
            }
            connection = DriverManager.getConnection(DB_URL);
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
                    String photo = rs.getString("photo_url");
                    if((roomPrice >= price1 && roomPrice < price2) || price2 == 0) {
                        Room temp = new Room(roomId, roomSize, roomTvibreitt, roomPrice, hotel.get(i), photo);
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
    
    public static int getUsers() {
        int count = 0;
        Connection connection = null;
        try {
            connection =  DriverManager.getConnection(DB_URL);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            String searchForUser = "SELECT * from User";
            ResultSet rs = statement.executeQuery(searchForUser);
            while(rs.next()) {
                count++;
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
        return count;
    }

    public static String getUsernames(String username) {
        String s = "";
        Connection connection = null;
        try {
            connection =  DriverManager.getConnection(DB_URL);
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
    
    public static boolean isDateReserved(ArrayList<Date> dates, int roomId) {
        Connection connection = null;
        boolean isReserved = true;
        try {
            connection =  DriverManager.getConnection(DB_URL);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            for(int i = 0; i<dates.size(); i++) {
                DateFormat oDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String sDate1 = oDateFormat.format(dates.get(i)).replace("-", " ");
                System.out.print(sDate1 + " ");
                String reserved = "SELECT * from Reservation where roomId = '" + roomId + "'" + " AND DATE = '" + sDate1 + "'";
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
    
    public static void reserveDate(Date date, String userId, String roomId) {
        Connection connection = null;
        try {
            DateFormat oDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String sDate1 = oDateFormat.format(date).replace("-", " ");
            System.out.print(sDate1 + " ");
            connection =  DriverManager.getConnection(DB_URL);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            String query = "INSERT INTO Reservation(roomId, userId, date) VALUES ('" + roomId + "', '" + userId +"', '" + sDate1 + "')";
            statement.executeUpdate(query);
        } 
        catch (SQLException ex) {
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
    }
    
    public static int registerDatabase(String query) {
        int executeUpdate = 0;
        try {
            System.out.print(query);
            Connection connection =  DriverManager.getConnection(DB_URL);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            executeUpdate = statement.executeUpdate(query);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        return executeUpdate;
    }

    public static int loginDatabase(String username, String password) {
        Connection connection = null;
        int log = -1;
        try {    
            connection = DriverManager.getConnection(DB_URL);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            ResultSet rs = statement.executeQuery("SELECT * from User WHERE username = '" + username + "' AND password = '" + password + "'");
            while (rs.next()) {
                String stringLog = rs.getString("id");
                System.out.print(stringLog);
                log = Integer.parseInt(stringLog);
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
