package controls;

import javax.faces.bean.ManagedBean;

import beans.SavedResearche;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;

import dao.SavedResearcheDAO;
import tools.MainTool;

@ManagedBean
@ApplicationScoped
public class SavedResearcheCtrl implements Serializable {

	public SavedResearche getSavedResearche() {
		return savedResearche;
	}

	public void setSavedResearche(SavedResearche savedResearche) {
		this.savedResearche = savedResearche;
	}

	private SavedResearcheDAO savedResearchedao;
	private SavedResearche savedResearche;
	private MainTool o;

	public SavedResearcheCtrl() {
		this.savedResearche = new SavedResearche();
		this.savedResearchedao = new SavedResearcheDAO();
		this.o = new MainTool();
	}

	public SavedResearcheDAO getSavedResearchedao() {
		return savedResearchedao;
	}

	public MainTool getO() {
		return o;
	}

	public void setSavedResearchedao(SavedResearcheDAO savedResearchedao) {
		this.savedResearchedao = savedResearchedao;
	}

	public String saveSavedResearche() {
		savedResearchedao.insertSavedResearche(savedResearche);
		return "";
	}

	public String updateSavedResearche() {
		savedResearchedao.editSavedResearche(savedResearche);
		return "";
	}

}
