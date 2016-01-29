package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Person;
import dao.PersonDAO;

/**
 * Servlet implementation class RegisterValidationServlet
 */
@WebServlet("/RegisterValidation")
public class RegisterValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterValidationServlet() {
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

		String password = "" + request.getParameter("password");
		String password_confirm = "" + request.getParameter("passwd_repeated");
		String username = "" + request.getParameter("username");
		String firstname = "" + request.getParameter("firstname");
		String lastname = "" + request.getParameter("lastname");
		String address = "" + request.getParameter("address");
		String city = "" + request.getParameter("city");
		String cellnumber = "" + request.getParameter("cellnumber");
		String email = "" + request.getParameter("email");

		PersonDAO pDao = new PersonDAO();
		Person p = new Person(firstname, lastname, email, password, username, address, city, cellnumber, false);
		request.setAttribute("validParams", p);

		if (!pDao.doesPersonByEmailOrUsernameAlreadyExists(email, username)) {
			pDao.insertPerson(p);
			request.getSession().setAttribute("user", p);
			dispatcher = request.getRequestDispatcher("account.jsp");

		} else
			dispatcher = request.getRequestDispatcher("register.jsp");

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
