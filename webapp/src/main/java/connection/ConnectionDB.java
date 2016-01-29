package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	
	private static volatile Connection instance = null;
	
	public ConnectionDB(){
		super();
	}
	
	public final static Connection getInstance() {
		if (ConnectionDB.instance == null) {
            synchronized(ConnectionDB.class) {
              if (ConnectionDB.instance == null) {
            	try {
          			Class.forName("com.mysql.jdbc.Driver");
          		} catch (ClassNotFoundException e) {
          			e.printStackTrace();
          		}
          	    String url = "jdbc:mysql://localhost:3306/javaee";
          	    String user = "root";
          	    String password = "";
          	    try {
          	    	instance = DriverManager.getConnection(url, user, password);
          	    	System.out.println("Connection completed.");
          	    } catch (SQLException ex) {
          	    	System.out.println(ex.getMessage());
          	    }
          	    finally{
          	    }
              }
           }
        }
        return ConnectionDB.instance;
	}
}
