package controls;

import javax.faces.bean.ManagedBean;

import beans.Announce;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;

import dao.AnnounceDAO;
import tools.MainTool;

@ManagedBean
@ApplicationScoped
public class AnnounceCtrl implements Serializable{

	public Announce getAnnounce() {
		return announce;
	}

	public void setAnnounce(Announce announce) {
		this.announce = announce;
	}

	private AnnounceDAO announcedao;
	private Announce announce;
	private MainTool o;
	
	public AnnounceCtrl(){
		this.announce = new Announce();
		this.announcedao = new AnnounceDAO();
		this.o = new MainTool();
	}

	public AnnounceDAO getAnnouncedao() {
		return announcedao;
	}

	public MainTool getO() {
		return o;
	}

	public void setAnnouncedao(AnnounceDAO announcedao) {
		this.announcedao = announcedao;
	}
	
	public String saveAnnounce(){
		announcedao.insertAnnounce(announce);
		return "";
	}
	
	public String updateAnnounce(){
		announcedao.editAnnounce(announce);
		return "";
	}
	

}
