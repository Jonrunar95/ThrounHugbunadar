package Model;

public class Hotel {
	
	private int hotelId;
	private String name;
	private String location;
	private int stars;
	private String photo_url;
	private String[] conveniences;
	
	public Hotel(int hotelId, String name, String location, int stars, String photo_url, String[] conveniences) {
		this.hotelId = hotelId;
		this.name = name;
		this.location = location;
		this.stars = stars;
		this.photo_url = photo_url;
		this.conveniences = conveniences;
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
}