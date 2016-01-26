package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Personne;
import connection.ConnectionDB;

public class PersonneDAO {
	private List<Personne> personnes = new ArrayList<Personne>();
	private ConnectionDB connectiondb;
	
	public PersonneDAO(){
		this.connectiondb = new ConnectionDB();
		this.personnes = getAllPersonnes();
	}
	
	public List<Personne> getPersonnes(){
		return this.personnes;
	}
	
	public List<Personne> getAllPersonnes(){
		 ResultSet result = null;
	     java.sql.PreparedStatement statement = null;
	     String request = "SELECT * FROM javaee.personne";
	     List<Personne> personnes = new ArrayList<Personne>();
	     
	     try {   
	    	 statement = connectiondb.getConnection().prepareStatement(request);
	         statement.execute();
	         result = statement.getResultSet();

	         while(result.next()){
	            Personne personne = new Personne();
	            personne.setId(result.getInt(1));
	            personne.setForename(result.getString(2));
	            personne.setSurname(result.getString(3));
	            personne.setNaissance(result.getDate(4));
	            personnes.add(personne);				
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return personnes;
	}
	
	public void insertPersonne(String f, String s, String n){
	    Statement statement = null;
	    String request = "INSERT INTO javaee.personne(forename, surname, naissance) VALUES('"+f+"', '"+s+"', '"+n+"');";
	    
	    try {   
	    	 statement = connectiondb.getConnection().createStatement();
	         statement.executeUpdate(request);

	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }
	    this.personnes = getAllPersonnes();
	}
	
	public void editPersonne(int i, String f, String s, String n){
		Statement statement = null;
		System.out.println(i);
		System.out.println(f);
		System.out.println(s);
		System.out.println(n);
	    String request = "UPDATE javaee.personne SET forename='"+f+"', surname='"+s+"', naissance='"+n+"' WHERE personne.id="+i+";";
	    
	    try {   
	    	 statement = connectiondb.getConnection().createStatement();
	         statement.executeUpdate(request);
	         System.out.println("Update completed.");

	    } catch (SQLException e) {
	    	e.printStackTrace();
	    	System.out.println("Update failled.");
	    }
	    this.personnes = getAllPersonnes();
	}
}
