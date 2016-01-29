package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.omg.PortableServer.AdapterActivator;

import beans.Announce;
import connection.ConnectionDB;

public class AnnounceDAO {
	private List<Announce> announces = new ArrayList<Announce>();
	private ConnectionDB connectiondb;

	public AnnounceDAO() {
		this.connectiondb = new ConnectionDB();
		this.announces = getAllAnnounces();
	}

	public List<Announce> getAnnounces() {
		return this.announces;
	}

	public List<Announce> getAllAnnounces() {
		ResultSet result = null;
		java.sql.PreparedStatement statement = null;
		String request = "SELECT * FROM javaee.announce";
		List<Announce> announces = new ArrayList<Announce>();

		try {
			statement = connectiondb.getInstance().prepareStatement(request);
			statement.execute();
			result = statement.getResultSet();

			while (result.next()) {

				Announce announce = new Announce();
				announce.setId(result.getInt(1));
				announce.setPrice(Float.parseFloat("" + result.getInt(2)));
				announce.setType(result.getString(3));
				announce.setSurface(Float.parseFloat("" + result.getString(4)));
				announce.setAddress(result.getString(5));
				announce.setCity(result.getString(6));
				announce.setDescription(result.getString(7));
				announce.setUserID(result.getInt(8));

				if (result.getString(8).equals("false"))
					announce.setExpired(false);
				else
					announce.setExpired(true);

				announces.add(announce);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return announces;
	}

	public Announce getAnnounce(int announceId) {
		ResultSet result = null;
		java.sql.PreparedStatement statement = null;
		String request = "SELECT * FROM javaee.announce WHERE announce.id='" + announceId + "';";
		Announce announce = new Announce();

		try {
			statement = connectiondb.getInstance().prepareStatement(request);
			statement.execute();
			result = statement.getResultSet();

			while (result.next()) {

				announce.setId(result.getInt(1));
				announce.setPrice(Float.parseFloat("" + result.getInt(2)));
				announce.setType(result.getString(3));
				announce.setSurface(Float.parseFloat("" + result.getString(4)));
				announce.setAddress(result.getString(5));
				announce.setCity(result.getString(6));
				announce.setDescription(result.getString(7));
				announce.setUserID(result.getInt(8));

				if (result.getString(8).equals("false"))
					announce.setExpired(false);
				else
					announce.setExpired(true);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return announce;
	}

	public List<Announce> getAnnouncesByCriterias(int price_min, int price_max, String type, int surface_min,
			int surface_max, String city) {
		ResultSet result = null;
		java.sql.PreparedStatement statement = null;
		List<Announce> announces = new ArrayList<Announce>();

		String request = "SELECT * FROM javaee.announce WHERE announce.price > " + price_min + " AND announce.price < "
				+ price_max + " AND announce.type LIKE '%" + type + "%' AND announce.surface > " + surface_min
				+ " AND announce.surface < " + surface_max + " AND announce.city LIKE '%" + city + "%';";
		System.out.println(request);
		try {
			statement = connectiondb.getInstance().prepareStatement(request);
			statement.execute();
			result = statement.getResultSet();

			while (result.next()) {

				Announce announce = new Announce();
				announce.setId(result.getInt(1));
				announce.setPrice(Float.parseFloat("" + result.getInt(2)));
				announce.setType(result.getString(3));
				announce.setSurface(Float.parseFloat("" + result.getString(4)));
				announce.setAddress(result.getString(5));
				announce.setCity(result.getString(6));
				announce.setDescription(result.getString(7));
				announce.setUserID(result.getInt(8));

				if (result.getString(8).equals("false"))
					announce.setExpired(false);
				else
					announce.setExpired(true);

				announces.add(announce);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return announces;
	}

	public List<Announce> getAnnouncesByUserID(int userID) {
		ResultSet result = null;
		List<Announce> announces = new ArrayList<Announce>();
		java.sql.PreparedStatement statement = null;
		String request = "SELECT * FROM javaee.announce WHERE announce.userID='" + userID + "';";

		try {
			statement = connectiondb.getInstance().prepareStatement(request);
			statement.execute();
			result = statement.getResultSet();

			while (result.next()) {
				Announce announce = new Announce();

				announce.setId(result.getInt(1));
				announce.setPrice(Float.parseFloat("" + result.getInt(2)));
				announce.setType(result.getString(3));
				announce.setSurface(Float.parseFloat("" + result.getString(4)));
				announce.setAddress(result.getString(5));
				announce.setCity(result.getString(6));
				announce.setDescription(result.getString(7));
				announce.setUserID(result.getInt(9));

				if (result.getString(8).equals("false"))
					announce.setExpired(false);
				else
					announce.setExpired(true);

				announces.add(announce);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return announces;
	}

	public void insertAnnounce(Announce a) {
		Statement statement = null;
		String request = "INSERT INTO javaee.announce(price, type, surface, address, city, description, expired) "
				+ "VALUES('" + a.getPrice() + "', '" + a.getType() + "', '" + a.getSurface() + "'," + " '"
				+ a.getAddress() + "', '" + a.getCity() + "', '" + a.getDescription() + "', '" + a.isExpired() + "');";

		try {
			statement = connectiondb.getInstance().createStatement();
			statement.executeUpdate(request);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// this.announces = getAllAnnounces();
	}

	public void editAnnounce(Announce a) {
		Statement statement = null;
		System.out.println(a.getId());
		String request = "UPDATE javaee.announce SET price='" + a.getPrice() + "', type='" + a.getType()
				+ "', surface='" + a.getSurface() + "', address='" + a.getAddress() + "', city='" + a.getCity()
				+ "', description='" + a.getDescription() + "' WHERE announce.id='" + a.getId() + "';";

		try {
			statement = connectiondb.getInstance().createStatement();
			statement.executeUpdate(request);
			System.out.println("Update completed.");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Update failled.");
		}
		this.announces = getAllAnnounces();
	}
}
