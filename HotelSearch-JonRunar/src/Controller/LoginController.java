/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.DatabaseController.loginDatabase;

/**
 *
 * @author Notandi
 */
public class LoginController {
    
    public static int login(String username, String password) {
        int log = loginDatabase(username, password);
        return log;
    }
}