package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.omg.PortableServer.AdapterActivator;

import beans.SavedResearche;
import connection.ConnectionDB;

public class SavedResearcheDAO {
	private List<SavedResearche> savedResearches = new ArrayList<SavedResearche>();
	private ConnectionDB connectiondb;

	public SavedResearcheDAO() {
		this.connectiondb = new ConnectionDB();
		this.savedResearches = getAllSavedResearches();
	}

	public List<SavedResearche> getSavedResearches() {
		return this.savedResearches;
	}

	public List<SavedResearche> getAllSavedResearches() {
		ResultSet result = null;
		java.sql.PreparedStatement statement = null;
		String request = "SELECT * FROM javaee.saved_researche";
		List<SavedResearche> savedResearches = new ArrayList<SavedResearche>();

		try {
			statement = connectiondb.getInstance().prepareStatement(request);
			statement.execute();
			result = statement.getResultSet();

			while (result.next()) {

				SavedResearche savedResearche = new SavedResearche();
				savedResearche.setId(result.getInt(1));
				savedResearche.setPrice(Float.parseFloat("" + result.getInt(2)));
				savedResearche.setType(result.getString(3));
				savedResearche.setSurface(Float.parseFloat("" + result.getString(4)));
				savedResearche.setCity(result.getString(5));
				savedResearche.setUserID(result.getInt(6));

				savedResearches.add(savedResearche);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return savedResearches;
	}

	public void insertSavedResearche(SavedResearche sr) {
		Statement statement2 = null;
		ResultSet result = null;
		java.sql.PreparedStatement statement1 = null;

		String requestGET = "SELECT * FROM javaee.saved_researche WHERE saved_researche.price = '" + sr.getPrice()
				+ "' AND saved_researche.type = '" + sr.getType() + "' AND saved_researche.surface = '"
				+ sr.getSurface() + "' AND saved_researche.city = '" + sr.getCity() + "' AND saved_researche.userID = '"
				+ sr.getUserID() + "';";

		String requestINSERT = "INSERT INTO javaee.saved_researche(price, type, surface, city) " + "VALUES('"
				+ sr.getPrice() + "', '" + sr.getType() + "', '" + sr.getSurface() + "'," + " '" + sr.getCity() + "');";

		try {

			statement1 = connectiondb.getInstance().prepareStatement(requestGET);
			statement1.execute(requestGET);
			result = statement1.getResultSet();
			// if already exists
			if (!result.next()) {
				statement2 = connectiondb.getInstance().createStatement();
				statement2.executeUpdate(requestINSERT);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// this.savedResearches = getAllSavedResearches();
	}

	public void editSavedResearche(SavedResearche a) {
		Statement statement = null;
		System.out.println(a.getId());
		String request = "UPDATE javaee.savedResearche SET price='" + a.getPrice() + "', type='" + a.getType()
				+ "', surface='" + a.getSurface() + "', city='" + a.getCity() + "' WHERE saved_researche.id='"
				+ a.getId() + "';";

		try {
			statement = connectiondb.getInstance().createStatement();
			statement.executeUpdate(request);
			System.out.println("Update completed.");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Update failled.");
		}
		this.savedResearches = getAllSavedResearches();
	}
}
