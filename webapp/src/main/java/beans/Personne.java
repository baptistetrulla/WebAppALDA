package beans;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.validation.constraints.Past;

public class Personne implements java.io.Serializable{
	
	private int id;

	@Size(min = 1, message = "Le prénom est obligatoire !")
	private String forename;
	
	@Size(min = 1, message = "Le nom est obligatoire !")
	private String surname;
	
	@Past
	private Date naissance;
	
	public Personne(){
		this.forename = "";
		this.surname = "";
		this.naissance = new Date();
	}
	
	public Personne(String f, String s, Date d){
		this.forename = f;
		this.surname = s;
		this.naissance = d;
	}
	
	public String getForename() {
	    return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}
	
	public String getSurname() {
	    return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getNaissance() {
		return naissance;
	}

	public void setNaissance(Date d) {
		this.naissance = d;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
