package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.ioLocalStorage.ioType.IOSQL;
import userInterface.Validation;

/**
 * Servlet implementation class updateGroup
 */
@WebServlet("/updateGroup")
public class updateGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String GROUP_PATTERN = "^[A-Z0-9][a-z0-9]+[ ]{0,1}[-]{0,1}([ ]{0,1}[A-Z0-9]{0,1}[a-z0-9]*)*$";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateGroup() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String job = (String) request.getParameter("job");
		String idGroup = (String) request.getParameter("idGroup");
		String groupName = (String) request.getParameter("groupName");
		IOSQL iosql = new IOSQL();
		if (job.equals("add")) {
			iosql.addGroup(groupName);
		} else if (job.equals("update")) {
			iosql.updateGroup(idGroup, groupName);
		} else if (job.equals("remove")) {
			iosql.removeGroup(idGroup);
		}
		
		response.sendRedirect("/CollegeWEB/outGroupsTable");
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
