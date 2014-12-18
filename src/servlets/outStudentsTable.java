package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.SQLUtil.ConnectionConfiguration;

/**
 * Servlet implementation class groupsTable
 */
@WebServlet("/outStudentsTable")
public class outStudentsTable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public outStudentsTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try (Connection connection = new ConnectionConfiguration()
				.getConnection();
				Statement statement = connection.createStatement();) {
			String idGroup = (String) request.getParameter("idGroup");
			String query = "SELECT students.idStudent, students.firstName,students.lastName, groups.groupName "
					+ "FROM groups INNER JOIN students ON students.idGroup = groups.idGroup "
					+ "WHEREgroups.idGroup = " + idGroup;
			ResultSet resultSet = statement.executeQuery(query);
			request.setAttribute("Students", resultSet);
			request.getRequestDispatcher("studentsTable.jsp").forward(request,
					response);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
