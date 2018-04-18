/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.DatabaseController.getReservationsById;
import Model.Hotel;
import java.util.ArrayList;
import static Controller.DatabaseController.getReviewsDatabase;
import static Controller.DatabaseController.getReviewsById;
import Model.HotelReview;
import Model.Reservation;



/**
 *
 * @author Notandi
 */
public class ReviewController {
    public static ArrayList<HotelReview> getReviews(Hotel hotel) {
        ArrayList<HotelReview> reviews = getReviewsDatabase(hotel.getHotelId() +"");
        return reviews;
    }
    
    public static ArrayList<HotelReview> getHotelReviewByUserId(int id) {
            ArrayList<HotelReview> hotelReviews = getReviewsById(id);
            return hotelReviews;
    }
    
    public static ArrayList<Reservation> getReservationsByUserId(int id) {
        ArrayList<Reservation> Reservations = getReservationsById(id);
        return Reservations;
    }
}
