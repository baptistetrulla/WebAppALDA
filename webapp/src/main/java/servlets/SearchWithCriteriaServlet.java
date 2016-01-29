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
import beans.Photo;
import dao.AnnounceDAO;
import dao.PhotoDAO;

/**
 * Servlet implementation class SearchWithCriteriaServlet
 */
@WebServlet("/SearchWithCriteriaServlet")
public class SearchWithCriteriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchWithCriteriaServlet() {
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

		int price_min, price_max;
		int surface_min, surface_max;

		int selectPrice = Integer.parseInt(request.getParameter("selectPrice"));
		String selectType = "" + request.getParameter("selectType");
		int selectSurface = Integer.parseInt(request.getParameter("selectSurface"));
		String selectCity = "" + request.getParameter("inputCity");

		price_min = selectPrice * 25000;
		price_max = selectPrice * 25000 + 25000;

		surface_min = selectSurface * 5;
		surface_max = selectSurface * 5 + 5;
		List<Announce> resultSearch = new ArrayList<Announce>();
		AnnounceDAO aDao = new AnnounceDAO();

		resultSearch = aDao.getAnnouncesByCriterias(price_min, price_max, selectType, surface_min, surface_max,
				selectCity);

		PhotoDAO phDao = new PhotoDAO();

		List<Photo> photos = new ArrayList<Photo>();

		for (int i = 0; i < resultSearch.size(); i++) {
			photos = phDao.getAllPhotosForAnnounceId(resultSearch.get(i).getId());

			resultSearch.get(i).setPhotos(photos);
		}

		request.getSession().setAttribute("recentSales", resultSearch);

		request.getRequestDispatcher("./search.jsp").forward(request, response);

		doGet(request, response);
	}

}
