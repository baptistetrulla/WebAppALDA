package controls;

import javax.faces.bean.ManagedBean;

import beans.FavoriteAnnounce;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;

import dao.FavoriteAnnounceDAO;
import tools.MainTool;

@ManagedBean
@ApplicationScoped
public class FavoriteAnnounceCtrl implements Serializable {

	public FavoriteAnnounce getFavoriteAnnounce() {
		return favoriteAnnounce;
	}

	public void setFavoriteAnnounce(FavoriteAnnounce favoriteAnnounce) {
		this.favoriteAnnounce = favoriteAnnounce;
	}

	private FavoriteAnnounceDAO favoriteAnnouncedao;
	private FavoriteAnnounce favoriteAnnounce;
	private MainTool o;

	public FavoriteAnnounceCtrl() {
		this.favoriteAnnounce = new FavoriteAnnounce();
		this.favoriteAnnouncedao = new FavoriteAnnounceDAO();
		this.o = new MainTool();
	}

	public FavoriteAnnounceDAO getFavoriteAnnouncedao() {
		return favoriteAnnouncedao;
	}

	public MainTool getO() {
		return o;
	}

	public void setFavoriteAnnouncedao(FavoriteAnnounceDAO favoriteAnnouncedao) {
		this.favoriteAnnouncedao = favoriteAnnouncedao;
	}

	public String saveFavoriteAnnounce() {
		favoriteAnnouncedao.insertFavoriteAnnounce(favoriteAnnounce);
		return "";
	}

}
