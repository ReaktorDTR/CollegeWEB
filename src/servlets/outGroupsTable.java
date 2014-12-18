package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.ioLocalStorage.ioType.IOSQL;
import entity.Group;


/**
 * Servlet implementation class groupsTable
 */
@WebServlet("/outGroupsTable")
public class outGroupsTable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public outGroupsTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		IOSQL iosql = new IOSQL();
		List<Group> groupsTable = new ArrayList<>();
		groupsTable = iosql.getGroupsTable();
		request.setAttribute("Groups", groupsTable);
		request.getRequestDispatcher("groupsTable.jsp").forward(request, response);
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
