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
import beans.Person;
import beans.Photo;
import dao.AnnounceDAO;
import dao.PersonDAO;
import dao.PhotoDAO;

@WebServlet("/Index")
public class MainPageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AnnounceDAO aDao = new AnnounceDAO();
		List<Announce> allAnnounces = aDao.getAllAnnounces();
		PhotoDAO phDao = new PhotoDAO();

		List<Photo> photos = new ArrayList<Photo>();

		for (int i = 0; i < allAnnounces.size(); i++) {
			photos = phDao.getAllPhotosForAnnounceId(allAnnounces.get(i).getId());

			allAnnounces.get(i).setPhotos(photos);
		}

		req.setAttribute("recentSales", allAnnounces);
		req.getRequestDispatcher("/search.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
}
