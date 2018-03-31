package Model;

public class Hotel {
	
	private int hotelId;
	private String name;
	private String location;
	private int stars;
	private String photo_url;
	private String[] conveniences;
	private HotelReview[] hotelReviews;
	private Room[] rooms;
	
	public Hotel(int hotelId, String name, String location, int stars, String photo_url, String[] conveniences, Room[] rooms) {
		this.hotelId = hotelId;
		this.name = name;
		this.location = location;
		this.stars = stars;
		this.photo_url = photo_url;
		this.conveniences = conveniences;
		this.rooms = rooms;
	}
	
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public String getPhoto_URL() {
		return photo_url;
	}
	public void setPhoto_URL(String photo_url) {
		this.photo_url = photo_url;
	}
	public String[] getConveniences() {
		return conveniences;
	}
	public void setConveniences(String[] conveniences) {
		this.conveniences = conveniences;
	}
	public 	HotelReview[] getHotelReviews() {
		return hotelReviews;
	}
	public void setHotelReviews(HotelReview[] hotelReviews) {
		this.hotelReviews = hotelReviews;
	}
	public Room[] getRooms() {
		return rooms;
	}
	public void setRooms(Room[] rooms) {
		this.rooms = rooms;
	}
	public void addHotelReview(HotelReview hotelReview) {
		HotelReview[] temp = hotelReviews;
		hotelReviews = new HotelReview[temp.length+1];
		for(int i=0; i<temp.length-1; i++) {
			hotelReviews[i] = temp[i];
		}
		hotelReviews[temp.length] = hotelReview;
	}
}