package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.omg.PortableServer.AdapterActivator;

import beans.FavoriteAnnounce;
import connection.ConnectionDB;

public class FavoriteAnnounceDAO {
	private List<FavoriteAnnounce> favoriteFavoriteAnnounces = new ArrayList<FavoriteAnnounce>();
	private ConnectionDB connectiondb;

	public FavoriteAnnounceDAO() {
		this.connectiondb = new ConnectionDB();
		this.favoriteFavoriteAnnounces = getAllFavoriteAnnounces();
	}

	public List<FavoriteAnnounce> getFavoriteAnnounces() {
		return this.favoriteFavoriteAnnounces;
	}

	public List<FavoriteAnnounce> getAllFavoriteAnnounces() {
		ResultSet result = null;
		java.sql.PreparedStatement statement = null;
		String request = "SELECT * FROM javaee.favorite_announce";
		List<FavoriteAnnounce> favoriteFavoriteAnnounces = new ArrayList<FavoriteAnnounce>();

		try {
			statement = connectiondb.getInstance().prepareStatement(request);
			statement.execute();
			result = statement.getResultSet();

			while (result.next()) {

				FavoriteAnnounce favoriteFavoriteAnnounce = new FavoriteAnnounce();
				favoriteFavoriteAnnounce.setId(result.getInt(1));
				favoriteFavoriteAnnounce.setUserID(result.getInt(2));
				favoriteFavoriteAnnounce.setAnnounceID(result.getInt(3));

				favoriteFavoriteAnnounces.add(favoriteFavoriteAnnounce);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return favoriteFavoriteAnnounces;
	}

	public List<FavoriteAnnounce> getAllFavoriteAnnouncesForUserId(int userId) {
		ResultSet result = null;
		java.sql.PreparedStatement statement = null;
		String request = "SELECT * FROM javaee.favorite_announce WHERE favorite_announce.userID='" + userId + "';";
		List<FavoriteAnnounce> favoriteFavoriteAnnounces = new ArrayList<FavoriteAnnounce>();

		try {
			statement = connectiondb.getInstance().prepareStatement(request);
			statement.execute();
			result = statement.getResultSet();

			while (result.next()) {

				FavoriteAnnounce favoriteFavoriteAnnounce = new FavoriteAnnounce();
				favoriteFavoriteAnnounce.setId(result.getInt(1));
				favoriteFavoriteAnnounce.setUserID(result.getInt(2));
				favoriteFavoriteAnnounce.setAnnounceID(result.getInt(3));

				favoriteFavoriteAnnounces.add(favoriteFavoriteAnnounce);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return favoriteFavoriteAnnounces;
	}

	public void insertFavoriteAnnounce(FavoriteAnnounce fa) {
		Statement statement2 = null;
		ResultSet result = null;
		java.sql.PreparedStatement statement1 = null;
		String requestGET = "SELECT * FROM javaee.favorite_announce WHERE favorite_announce.userID = '" + fa.getUserID()
				+ "' AND favorite_announce.announceID = '" + fa.getAnnounceID() + "';";

		String requestINSERT = "INSERT INTO javaee.favorite_announce(userID, announceID) " + "VALUES('" + fa.getUserID()
				+ "', '" + fa.getAnnounceID() + "');";

		try {

			statement1 = connectiondb.getInstance().prepareStatement(requestGET);
			statement1.execute(requestGET);
			result = statement1.getResultSet();

			if (!result.next()) {
				statement2 = connectiondb.getInstance().createStatement();
				statement2.executeUpdate(requestINSERT);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteFavoriteAnnounce(FavoriteAnnounce fa) {
		Statement statement = null;
		String request = "DELETE javaee.favorite_announce WHERE userID='" + fa.getUserID() + "' AND anounceID='"
				+ fa.getAnnounceID() + "';";

		try {
			statement = connectiondb.getInstance().createStatement();
			statement.executeUpdate(request);
			System.out.println("Update completed.");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Update failled.");
		}
		this.favoriteFavoriteAnnounces = getAllFavoriteAnnounces();
	}
}
