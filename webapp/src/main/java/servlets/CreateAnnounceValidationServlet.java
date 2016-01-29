package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Announce;
import dao.AnnounceDAO;

/**
 * Servlet implementation class CreateAnnounceServlet
 */
@WebServlet("/CreateAnnounceValidationServlet")
public class CreateAnnounceValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateAnnounceValidationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = null;

		// Check if user is logged in
		if (request.getSession().getAttribute("user") != null) {
			try {
				float price = Float.parseFloat(request.getParameter("price"));
				String type = "" + request.getParameter("type");
				float surface = Float.parseFloat(request.getParameter("surface"));
				String address = "" + request.getParameter("address");
				String city = "" + request.getParameter("city");
				String description = "" + request.getParameter("description");

				AnnounceDAO aDao = new AnnounceDAO();
				Announce a = new Announce(price, type, surface, address, city, description, false, (int)request.getSession().getAttribute("userID"));

				aDao.insertAnnounce(a);

				dispatcher = request.getRequestDispatcher("/Index");

				dispatcher.forward(request, response);

			} catch (Exception e) {
				dispatcher = request.getRequestDispatcher("/CreateAnnounceServlet");

				dispatcher.forward(request, response);
			}


		} else {

			dispatcher = request.getRequestDispatcher("login.jsp");

			dispatcher.forward(request, response);

		}

		doGet(request, response);
	}

}
