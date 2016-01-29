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
import beans.Person;
import dao.AnnounceDAO;
import dao.PersonDAO;

@WebServlet("/Admin")
public class AdminServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession() != null || req.getSession().getAttribute("user") != null) {
			Person p = new Person();
			p = (Person) req.getSession().getAttribute("user");
			if(!p.isAdmin()){
				req.getRequestDispatcher("/Index").forward(req, resp);
				System.out.println("Accès au panel d'admin non-autorisé par l'id " + p.getId());
				return;
			}
		}
		else {
			req.getRequestDispatcher("/Index").forward(req, resp);
			return;
		}
		
		PersonDAO perDao = new PersonDAO();
		AnnounceDAO aDao = new AnnounceDAO();
		List<Person> listP = new ArrayList<Person>();
		listP = perDao.getAllPersons();
		List<Announce> listA = new ArrayList<Announce>();
		listA = aDao.getAllAnnounces();
		
		req.setAttribute("nbUsers", listP.size());
		req.setAttribute("nbSales", listA.size());
		req.setAttribute("nbSalesExpired", aDao.getAnnouncesExpired().size());
		req.setAttribute("listUsers", listP);
		req.setAttribute("listSales", listA);
		
		req.getRequestDispatcher("admin.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
}
