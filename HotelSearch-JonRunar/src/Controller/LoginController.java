/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.HotelForm;
import View.LoginForm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Notandi
 */
public class LoginController {
    
    public static int login(String username, String password) {
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
        return log;
    }
}