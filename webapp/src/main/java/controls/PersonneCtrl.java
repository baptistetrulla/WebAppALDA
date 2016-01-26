package controls;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import beans.Personne;

import java.io.Serializable;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;

import dao.PersonneDAO;
import tools.MainTool;

@ManagedBean
@ApplicationScoped
public class PersonneCtrl implements Serializable{

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	private PersonneDAO personnedao;
	private Personne personne;
	private MainTool o;
	
	public PersonneCtrl(){
		this.personne = new Personne();
		this.personnedao = new PersonneDAO();
		this.o = new MainTool();
	}

	public PersonneDAO getPersonnedao() {
		return personnedao;
	}

	public MainTool getO() {
		return o;
	}

	public void setPersonnedao(PersonneDAO personnedao) {
		this.personnedao = personnedao;
	}
	
	public String savePersonne(){
		personnedao.insertPersonne(personne.getForename(), personne.getSurname(), o.convert(personne.getNaissance()));
		return "toList";
	}
	
	public String updatePersonne(){
		personnedao.editPersonne(personne.getId(), personne.getForename(), personne.getSurname(), o.convert(personne.getNaissance()));
		return "toList";
	}
	
	public String showModify(){
	      FacesContext fc = FacesContext.getCurrentInstance();
	      Map<String,String> params = 
	      fc.getExternalContext().getRequestParameterMap();
	      personne.setId(o.convertStringToInt(params.get("id")));
	      personne.setForename(params.get("prenom"));
	      personne.setSurname(params.get("nom"));
	      personne.setNaissance(o.convertStringToDate(params.get("naissance"))); 
	      return "modify";
	}

}
