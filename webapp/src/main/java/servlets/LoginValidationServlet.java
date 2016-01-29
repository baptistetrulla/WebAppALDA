package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Announce;
import beans.Person;
import beans.Photo;
import controls.PersonCtrl;
import dao.AnnounceDAO;
import dao.PersonDAO;
import dao.PhotoDAO;

/**
 * Servlet implementation class LoginValidationServlet
 */
@WebServlet("/LoginValidation")
public class LoginValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginValidationServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = null;
		int mapsize = request.getParameterMap().size();

		if (mapsize != 2 || !request.getParameterMap().containsKey("email")
				|| !request.getParameterMap().containsKey("password")) {

			dispatcher = request.getRequestDispatcher("login.jsp");

			dispatcher.forward(request, response);

		} else {

			PersonDAO pDao = new PersonDAO();
			Person p = new Person();
			p = pDao.getPersonByEmailAndPassword(request.getParameter("email"), request.getParameter("password"));
			request.getSession().setAttribute("userID", p.getId());
			request.getSession().setAttribute("user", p);

			if (p.getEmail() == null)
				dispatcher = request.getRequestDispatcher("login.jsp");
			else {
				AnnounceDAO aDao = new AnnounceDAO();
				List<Announce> allAnnounces = aDao.getAllAnnounces();
				PhotoDAO phDao = new PhotoDAO();

				List<Photo> photos = new ArrayList<Photo>();

				for (int i = 0; i < allAnnounces.size(); i++) {

					photos = phDao.getAllPhotosForAnnounceId(allAnnounces.get(i).getId());

					allAnnounces.get(i).setPhotos(photos);

				}

				request.getSession().setAttribute("recentSales", allAnnounces);
				dispatcher = request.getRequestDispatcher("search.jsp");
			}
			dispatcher.forward(request, response);
		}

	}
};
