package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.omg.PortableServer.AdapterActivator;

import beans.Photo;
import connection.ConnectionDB;

public class PhotoDAO {
	private List<Photo> photos = new ArrayList<Photo>();
	private ConnectionDB connectiondb;

	public PhotoDAO() {
		this.connectiondb = new ConnectionDB();
		this.photos = getAllPhotos();
	}

	public List<Photo> getPhotos() {
		return this.photos;
	}

	public List<Photo> getAllPhotos() {
		ResultSet result = null;
		java.sql.PreparedStatement statement = null;
		String request = "SELECT * FROM javaee.photo";
		List<Photo> photos = new ArrayList<Photo>();

		try {
			statement = connectiondb.getInstance().prepareStatement(request);
			statement.execute();
			result = statement.getResultSet();

			while (result.next()) {

				Photo photo = new Photo();
				photo.setId(result.getInt(1));
				photo.setDir(result.getString(2));
				photo.setAnnounceID(result.getInt(3));
				photo.setText(result.getString(4));

				photos.add(photo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return photos;
	}

	public List<Photo> getAllPhotosForAnnounceId(int announceId) {
		ResultSet result = null;
		java.sql.PreparedStatement statement = null;
		String request = "SELECT * FROM javaee.photo WHERE photo.announceID='" + announceId + "';";
		List<Photo> photos = new ArrayList<Photo>();

		try {
			statement = connectiondb.getInstance().prepareStatement(request);
			statement.execute();
			result = statement.getResultSet();

			while (result.next()) {

				Photo photo = new Photo();
				photo.setId(result.getInt(1));
				photo.setDir(result.getString(2));
				photo.setAnnounceID(result.getInt(3));
				photo.setText(result.getString(4));

				photos.add(photo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return photos;
	}

	public void insertPhoto(Photo p) {
		Statement statement = null;
		String request = "INSERT INTO javaee.photo(dir, announceID, text) " + "VALUES('" + p.getDir() + "', '"
				+ p.getAnnounceID() + "', '" + p.getText() + "');";

		try {
			statement = connectiondb.getInstance().createStatement();
			statement.executeUpdate(request);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// this.photos = getAllPhotos();
	}

	public void editPhoto(Photo p) {
		Statement statement = null;
		System.out.println(p.getId());
		String request = "UPDATE javaee.photo SET dir='" + p.getDir() + "', announceID='" + p.getAnnounceID()
				+ "', text='" + p.getText() + " WHERE photo.id='" + p.getId() + "';";

		try {
			statement = connectiondb.getInstance().createStatement();
			statement.executeUpdate(request);
			System.out.println("Update completed.");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Update failled.");
		}
		this.photos = getAllPhotos();
	}
}
