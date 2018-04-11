/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.DatabaseController.createRooms;
import static Controller.DatabaseController.getHotel;
import static Controller.DatabaseController.getRoom;
import Model.Hotel;
import Model.Room;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Notandi
 */
public class SearchController {
    static ArrayList<Hotel> hotel;
    
    static ArrayList<Room> room;

    /**
     *
     * @param checkBoxes
     * @param searchString
     * @return 
     */
    public static ArrayList<Room> search(String searchString, Date checkIn, Date checkOut, int size, boolean tvibreitt, int price, int stars) {
        hotel = new ArrayList<>();
        room = new ArrayList<>();
        //String[] queries = {"Fotlun", "Airport", "Wi-fi", "Gonguleid", "Likamsraekt", "Morgunmatur", "Midbaer", "Spa", "Sturta", "Tv", ""};
        String query = "";
        
        createRooms(searchString, query, tvibreitt);
        hotel = getHotel();
        room = getRoom();
        return room;
    }
}


