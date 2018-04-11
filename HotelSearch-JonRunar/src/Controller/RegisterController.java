/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.DatabaseController.getUsernames;
import static Controller.DatabaseController.registerDatabase;


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
     * @return 
     */
    public static String register(String name, String ssn, String username, String password1, String password2) {
        String s = "";
        s = getUsernames(username);

        if(name.equals("") || username.equals("") || password1.equals("")) {
            s = "Nýskráning mistókst, vinsamlegast fylltu í alla reitina!";
        } else if(!(password1.equals(password2))) {
            s = "Nýskráning mistókst, vinsamlegast hafðu sama password";
        } else if(s != ""){
            s = "Nýskráning mistókst, notendarnafn frátekið";
        } else if(ssn.length() != 10) {
            s = "Nýskráning mistókst, kennitala verður að vera 10 stafir";
        }
        else{
            String query = "INSERT INTO User(name, ssn, username, password) VALUES (" + name + ", " + ssn +", " + username + ", " + password1 + ")";
            int i = registerDatabase(query);
            if (i==1){
                s = "Nýskráning tókst";
            }
            else{
                s = "Nýskráning mistókst";
            }
        } 
        return s;
    }
}
