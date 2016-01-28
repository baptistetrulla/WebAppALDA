package controls;

import javax.faces.bean.ManagedBean;

import beans.Person;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;

import dao.PersonDAO;
import tools.MainTool;

@ManagedBean
@ApplicationScoped
public class PersonCtrl implements Serializable{

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	private PersonDAO persondao;
	private Person person;
	private MainTool o;
	
	public PersonCtrl(){
		this.person = new Person();
		this.persondao = new PersonDAO();
		this.o = new MainTool();
	}

	public PersonDAO getPersondao() {
		return persondao;
	}

	public MainTool getO() {
		return o;
	}

	public void setPersondao(PersonDAO persondao) {
		this.persondao = persondao;
	}
	
	public String savePerson(){
		persondao.insertPerson(person);
		return "";
	}
	
	public String updatePerson(){
		persondao.editPerson(person);
		return "";
	}
	

}
