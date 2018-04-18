/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.DatabaseController.createRooms;
import static Controller.DatabaseController.createHotels;
import static Controller.DatabaseController.isDateReserved;
import Model.Hotel;
import Model.Room;
import static java.lang.Integer.MAX_VALUE;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Notandi
 */
public class SearchController {
    static ArrayList<Hotel> hotel;
    
    static ArrayList<Room> room;
    
    static ArrayList<Date> totalDates;

    public static ArrayList<Hotel> getHotel() {
        return hotel;
    }

    public static ArrayList<Room> getRoom() {
        return room;
    }

    public static ArrayList<Date> getTotalDates() {
        return totalDates;
    }

    
    
    /**
     * @param searchString
     * @param checkIn
     * @param checkOut
     * @param size
     * @param tvibreitt
     * @param price
     * @param stars
     *
     * @return 
     */
    public static ArrayList<Room> search(String searchString, Date checkIn, Date checkOut, int size, boolean tvibreitt, int price, int stars) {
        hotel = new ArrayList<>();
        room = new ArrayList<>();
        totalDates = new ArrayList<>();
        //String[] queries = {"Fotlun", "Airport", "Wi-fi", "Gonguleid", "Likamsraekt", "Morgunmatur", "Midbaer", "Spa", "Sturta", "Tv", ""};
        
        int price1 = 0;
        int price2 = 0;
        if(price != 0) {
            switch (price) {
                case 1: price1 = 0;
                        price2=4999;
                         break;
                case 2: price1 = 5000;
                        price2=9999;
                         break;
                case 3: price1 = 10000;
                        price2=14999;
                         break;
                case 4: price1 = 15000;
                        price2=19999;
                         break;
                case 5: price1 = 20000;
                        price2= MAX_VALUE;
                         break;
            }
        }
        System.out.println(price1 + " - " + price2);
        while (!checkIn.after(checkOut)) {
            totalDates.add(checkIn);
            Date temp = new Date(checkIn.getTime() + TimeUnit.DAYS.toMillis( 1 ));
            checkIn = temp;
        }
        String query ="";

        if(stars != 0) {
            query = " AND stars = " + stars;
        }

        hotel = createHotels(searchString, query);
        System.out.println("Fjöldi hótela: " + hotel.size());
        System.out.println(size);
        System.out.println(tvibreitt);
        room = createRooms(hotel, size, tvibreitt, price1, price2, stars);
        ArrayList<Room> availableRooms = new ArrayList<>();
        
        for(int i = 0; i < room.size(); i++) {
            boolean b = isDateReserved(totalDates, room.get(i).getRoomid());
            if (b == true) {
                availableRooms.add(room.get(i));
            }
            
        }
        
        System.out.println("Fjöldi herbergja: " + availableRooms.size());
        
        return availableRooms;
    }
}


