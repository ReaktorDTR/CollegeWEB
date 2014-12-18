package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.ioLocalStorage.IOLocalStorage;
import database.LocalStorage;

/**
 * Servlet implementation class webBaseManager
 */
@WebServlet("/webBaseManager")
public class webBaseManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public webBaseManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		LocalStorage localStorage = new LocalStorage();
		IOLocalStorage ioLocalStorage = new IOLocalStorage();
		// TODO Auto-generated method stub
		String job = (String) request.getParameter("job");
		if (job.equals("From XML to SQL")) {
			localStorage = ioLocalStorage.loadFromXMLFile("C:\\Users\\sdovhtc\\Documents\\EclipseProjects\\CollegeWEB\\WebContent\\database.xml");
			ioLocalStorage.saveToSQL(localStorage);
		}
		response.sendRedirect("/CollegeWEB/");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
