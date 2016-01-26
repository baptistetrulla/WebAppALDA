package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	
	private Connection connection = null;
	
	public ConnectionDB(){
		if(this.connection==null){
			this.connection = createConnection();
		}
	}
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Connection createConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;

	    String url = "jdbc:mysql://localhost:3306/javaee";
	    String user = "root";
	    String password = "root";
	    try {
	    	connection = DriverManager.getConnection(url, user, password);
	    	System.out.println("Connection completed.");
	    } catch (SQLException ex) {
	    	System.out.println(ex.getMessage());
	    }
	    finally{
	    }
	    return connection;
	}

}
