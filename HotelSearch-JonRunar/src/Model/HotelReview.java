package Model;

public class HotelReview {
	
	private String textReview;
	private int starReview;
	private Hotel hotel;
	private User user;
	
	public HotelReview (String textReview, int starReview, Hotel hotel, User user) {
		this.textReview = textReview;
		this.starReview = starReview;
		this.hotel = hotel;
		this.user = user;
	}
	
	public String getTextReview() {
		return textReview;
	}
	public void setTextReview(String textReview) {
		this.textReview = textReview;
	}
	public int getStarReview() {
		return starReview;
	}
	public void setStarReview(int starReview) {
		this.starReview = starReview;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public User getUser() {
		return user;
	}
	public void setUser() {
		this.user = user;
	}
}