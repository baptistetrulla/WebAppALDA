package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Person;
import connection.ConnectionDB;

public class PersonDAO {
	private List<Person> persons = new ArrayList<Person>();
	private ConnectionDB connectiondb;

	public PersonDAO() {
		this.connectiondb = new ConnectionDB();
		this.persons = getAllPersons();
	}

	public List<Person> getPersonn() {
		return this.persons;
	}

	public List<Person> getAllPersons() {
		ResultSet result = null;
		java.sql.PreparedStatement statement = null;
		String request = "SELECT * FROM javaee.person";
		List<Person> persons = new ArrayList<Person>();

		try {
			statement = connectiondb.getInstance().prepareStatement(request);
			statement.execute();
			result = statement.getResultSet();

			while (result.next()) {

				Person person = new Person();
				person.setId(result.getInt(1));
				person.setEmail(result.getString(2));
				person.setPass(result.getString(3));
				person.setFirstname(result.getString(4));
				person.setLastname(result.getString(5));
				person.setUsername(result.getString(6));
				person.setAddress(result.getString(7));
				person.setCity(result.getString(8));
				person.setCellnumber(result.getString(9));

				if (result.getString(10).equals("false"))
					person.setAdmin(false);
				else
					person.setAdmin(true);

				persons.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return persons;
	}
	
	public Person getPersonByID(int userID) {
		ResultSet result = null;
		Person person = new Person();

		java.sql.PreparedStatement statement = null;
		String request = "SELECT * FROM javaee.person WHERE person.id = '" + userID + "';";

		try {
			statement = connectiondb.getInstance().prepareStatement(request);
			statement.execute();
			result = statement.getResultSet();

			while (result.next()) {

				person.setId(userID);
				person.setEmail(result.getString(2));
				person.setPass(result.getString(3));
				person.setFirstname(result.getString(4));
				person.setLastname(result.getString(5));
				person.setUsername(result.getString(6));
				person.setAddress(result.getString(7));
				person.setCity(result.getString(8));
				person.setCellnumber(result.getString(9));

				if (result.getString(10).equals("false"))
					person.setAdmin(false);
				else
					person.setAdmin(true);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return person;
	}

	public Person getPersonByEmailAndPassword(String email, String password) {
		ResultSet result = null;
		Person person = new Person();

		java.sql.PreparedStatement statement = null;
		String request = "SELECT * FROM javaee.person WHERE person.email = '" + email + "' AND person.pass='" + password
				+ "';";

		try {
			statement = connectiondb.getInstance().prepareStatement(request);
			statement.execute();
			result = statement.getResultSet();

			while (result.next()) {

				person.setId(result.getInt(1));
				person.setEmail(result.getString(2));
				person.setPass(result.getString(3));
				person.setFirstname(result.getString(4));
				person.setLastname(result.getString(5));
				person.setUsername(result.getString(6));
				person.setAddress(result.getString(7));
				person.setCity(result.getString(8));
				person.setCellnumber(result.getString(9));

				if (result.getString(10).equals("false"))
					person.setAdmin(false);
				else
					person.setAdmin(true);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return person;
	}

	public void insertPerson(Person p) {
		Statement statement = null;
		String request = "INSERT INTO javaee.person(firstname, lastname, email, pass, username,"
				+ " address, city, cellnumber, admin) " + "VALUES('" + p.getFirstname() + "', '" + p.getLastname()
				+ "', '" + p.getEmail() + "'," + " '" + p.getPass() + "', '" + p.getUsername() + "', '" + p.getAddress()
				+ "'," + " '" + p.getCity() + "', '" + p.getCellnumber() + "', '" + p.isAdmin() + "');";

		try {
			statement = connectiondb.getInstance().createStatement();
			statement.executeUpdate(request);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.persons = getAllPersons();
	}

	public void editPerson(Person p) {
		Statement statement = null;
		String request = "UPDATE javaee.person SET email='" + p.getEmail() + "', pass='" + p.getPass()
				+ "', firstname='" + p.getFirstname() + "', lastname='" + p.getLastname() + "', username='"
				+ p.getUsername() + "', address='" + p.getAddress() + "', city='" + p.getCity() + "', cellnumber='"
				+ p.getCellnumber() + "', admin='" + p.isAdmin() + "' WHERE person.email='" + p.getEmail() + "';";

		try {
			statement = connectiondb.getInstance().createStatement();
			System.out.println(request);
			statement.executeUpdate(request);
			System.out.println("Update completed.");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Update failled.");
		}
		this.persons = getAllPersons();
	}

	public void deletePerson(Person p) {
		Statement statement = null;
		String request = "DELETE FROM javaee.person WHERE person.email='" + p.getEmail() + "';";

		try {
			statement = connectiondb.getInstance().createStatement();
			System.out.println(request);
			statement.executeUpdate(request);
			System.out.println("Delete completed.");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Delete failled.");
		}
		this.persons = getAllPersons();
	}
}
