package beans;

import javax.validation.constraints.Size;

public class Person implements java.io.Serializable {

	private int id;

	@Size(min = 1, message = "Le prénom est obligatoire !")
	private String firstname;

	@Size(min = 1, message = "Le nom est obligatoire !")
	private String lastname;

	private String email;
	private String pass;
	private String username;
	private String address;
	private String city;
	private String cellnumber;
	private boolean admin;

	public Person() {
		this.firstname = "";
		this.lastname = "";
	}

	public Person(String firstname, String lastname, String email, String pass, String username, String address,
			String city, String cellnumber, boolean admin) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.pass = pass;
		this.username = username;
		this.address = address;
		this.city = city;
		this.cellnumber = cellnumber;
		this.admin = admin;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getCellnumber() {
		return cellnumber;
	}

	public void setCellnumber(String cellnumber) {
		this.cellnumber = cellnumber;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}
