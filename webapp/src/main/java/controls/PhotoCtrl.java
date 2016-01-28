package controls;

import javax.faces.bean.ManagedBean;

import beans.Photo;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;

import dao.PhotoDAO;
import tools.MainTool;

@ManagedBean
@ApplicationScoped
public class PhotoCtrl implements Serializable{

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	private PhotoDAO photodao;
	private Photo photo;
	private MainTool o;
	
	public PhotoCtrl(){
		this.photo = new Photo();
		this.photodao = new PhotoDAO();
		this.o = new MainTool();
	}

	public PhotoDAO getPhotodao() {
		return photodao;
	}

	public MainTool getO() {
		return o;
	}

	public void setPhotodao(PhotoDAO photodao) {
		this.photodao = photodao;
	}
	
	public String savePhoto(){
		photodao.insertPhoto(photo);
		return "";
	}
	
	public String updatePhoto(){
		photodao.editPhoto(photo);
		return "";
	}
	

}
