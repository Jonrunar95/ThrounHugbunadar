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
import javax.swing.JOptionPane;

/**
 *
 * @author Notandi
 */
public class RegisterController {

    /**
     *
     * @param name
     * @param ssn
     * @param username
     * @param password1
     * @param password2
     */
    public static String register(String name, String ssn, String username, String password1, String password2) {
        Connection connection = null;
        int log = 0;
        String s = "";
        try {
            connection =  DriverManager.getConnection("jdbc:sqlite:C:/Users/Notandi/Documents/Skóli/Þróun Hugbúnaðar/ThrounHugbunadar/Hoteldb.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            String searchForUser = "SELECT * from User where name = '" + username + "'";
            ResultSet rs = statement.executeQuery(searchForUser);
            
            if(name.equals("") || username.equals("") || password1.equals("")) {
                s = "Nýskráning mistókst, vinsamlegast fylltu í alla reitina!";
            } else if(!(password1.equals(password2))) {
                s = "Nýskráning mistókst, vinsamlegast hafðu sama password";
            } else if(rs.next()){
                s = "Nýskráning mistókst, notendarnafn frátekið";
            } else if(ssn.length() != 10) {
                s = "Nýskráning mistókst, kennitala verður að vera 10 stafir";
            }
            else{
                String query = "INSERT INTO User(name, ssn, username, password) VALUES (" + name + ", " + ssn +", " + username + ", " + password1 + ")";
                statement.executeUpdate(query);
                s = "Nýskráning tókst";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        return s;
    }
}
