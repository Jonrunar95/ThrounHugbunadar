/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Notandi
 */
public class Room {

    private int roomid;
    private int size;
    private boolean tvibreitt;
    private double price;
    private Hotel hotel;

    //Constructor
    public Room(int roomID, int roomSize, boolean roomTvibreitt, double roomPrice, Hotel roomHotel) {
        roomid = roomID;
        size = roomSize;
        tvibreitt = roomTvibreitt;
        price = roomPrice;
        hotel = roomHotel;
    }

    public boolean isReserved(Date date) {
        return false;
    }

    /**
     * @return the roomid
     */
    public int getRoomid() {
        return roomid;
    }

    /**
     * @param roomid the roomid to set
     */
    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }


    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean isTvibreitt() {
        return tvibreitt;
    }

    public void setTvibreitt(boolean tvibreitt) {
        this.tvibreitt = tvibreitt;
    }
    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the hotel
     */
    public Hotel getHotel() {
        return hotel;
    }

    /**
     * @param hotel the hotel to set
     */
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
