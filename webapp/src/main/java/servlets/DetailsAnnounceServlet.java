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
import dao.AnnounceDAO;
import dao.PersonDAO;
import dao.PhotoDAO;

/**
 * Servlet implementation class DetailsAnnounceServlet
 */
@WebServlet("/DetailsAnnounceServlet")
public class DetailsAnnounceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetailsAnnounceServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = null;

		Announce announce = new Announce();
		AnnounceDAO aDao = new AnnounceDAO();
		PhotoDAO phoDao = new PhotoDAO();
		List<Photo> photos = new ArrayList<Photo>();

		photos = phoDao.getAllPhotosForAnnounceId(Integer.parseInt(request.getParameter("announceId")));

		announce = aDao.getAnnounce(Integer.parseInt(request.getParameter("announceId")));
		announce.setPhotos(photos);
		
		request.getSession().setAttribute("sale", announce);
		
		PersonDAO perDao = new PersonDAO();
		System.out.println("id = " + announce.getId());
		Person p = perDao.getPersonByID(announce.getUserID());
		
		request.getSession().setAttribute("vendor", p);
		
		dispatcher = request.getRequestDispatcher("details-announce.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
