/**
 * 
 */
package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.FavoriteAnnounce;
import dao.FavoriteAnnounceDAO;

@WebServlet("/AddFavoriteAnnounce")
public class AddFavoriteAnnouceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession() == null || req.getSession().getAttribute("user") == null) {
			req.getRequestDispatcher("/Login").forward(req, resp);
			return;
		}
		
		FavoriteAnnounceDAO fDao = new FavoriteAnnounceDAO();
		FavoriteAnnounce fa = new FavoriteAnnounce((int) req.getSession().getAttribute("userID"), Integer.parseInt(req.getParameter("saleid")));
		fDao.insertFavoriteAnnounce(fa);
		
		req.getRequestDispatcher("/Favorites").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
