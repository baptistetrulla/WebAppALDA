/**
 * 
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Announce;
import beans.FavoriteAnnounce;
import beans.Photo;
import dao.AnnounceDAO;
import dao.FavoriteAnnounceDAO;
import dao.PhotoDAO;

@WebServlet("/Favorites")
public class FavoritesServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession() == null || req.getSession().getAttribute("user") == null) {
			req.getRequestDispatcher("/Login").forward(req, resp);
			return;
		}
		
		FavoriteAnnounceDAO fDao = new FavoriteAnnounceDAO();
		List<FavoriteAnnounce> listFa = fDao.getAllFavoriteAnnouncesForUserId((int)req.getSession().getAttribute("userID"));
		AnnounceDAO aDao = new AnnounceDAO();
		List<Announce> listA = new ArrayList<Announce>();
		PhotoDAO phoDao = new PhotoDAO();
		List<Photo> photos = new ArrayList<Photo>();
		int index = 0;

		for (FavoriteAnnounce favoriteAnnounce : listFa) {
			listA.add(aDao.getAnnounce(favoriteAnnounce.getAnnounceID()));
			photos = phoDao.getAllPhotosForAnnounceId(favoriteAnnounce.getAnnounceID());
			listA.get(index).setPhotos(photos);
		}
		
		req.setAttribute("favoritesSales", listA);
		req.getRequestDispatcher("favorites.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
}
