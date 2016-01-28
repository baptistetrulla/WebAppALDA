package beans;

public class SavedResearche {

	private int id;
	private float price;
	private String type;
	private float surface;
	private String city;
	private int userID;

	public SavedResearche() {
		this.price = 0;
		this.type = "";
		this.surface = 0;
		this.city = "";
		this.userID = 0;
	}

	public SavedResearche(float price, String type, float surface, String city) {
		this.price = price;
		this.type = type;
		this.surface = surface;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

}
