package beans;

import java.util.ArrayList;
import java.util.List;

public class Announce implements java.io.Serializable {

	private int id;
	private float price;
	private String type;
	private float surface;
	private String address;
	private String city;
	private String description;
	private boolean expired;
	private int userID;

	private List<Photo> photos = new ArrayList<Photo>();

	public Announce() {
		this.price = 0;
		this.type = "";
		this.surface = 0;
		this.address = "";
		this.city = "";
		this.description = "";
		this.expired = false;
		this.userID = 0;
	};

	public Announce(float price, String type, float surface, String address, String city, String description,
			boolean expired, int userID) {
		this.price = price;
		this.type = type;
		this.surface = surface;
		this.address = address;
		this.city = city;
		this.description = description;
		this.expired = expired;
		this.userID = userID;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getSurface() {
		return surface;
	}

	public void setSurface(float surface) {
		this.surface = surface;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

}
