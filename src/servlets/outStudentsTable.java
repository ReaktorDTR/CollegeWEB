package servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
			PrintWriter printWriter = response.getWriter();
			String query = "SELECT students.idStudent, students.firstName, students.lastName, groups.groupName FROM students INNER JOIN groups ON students.idGroup = groups.idGroup";
			ResultSet resultSet = statement.executeQuery(query);
			printWriter.println("<HTML>");
			printWriter.println("<BODY>");
			printWriter.println("<left>");
			printWriter
					.println("<table BORDER=1 CELLPADDING=0 CELLSPACING=0 WIDTH=50% >");
			printWriter.println("<tr>");
			printWriter.println("<td>ID</td>");
			printWriter.println("<td>FirstName</td>");
			printWriter.println("<td>LastName</td>");
			printWriter.println("<td>Group</td>");
			printWriter.println("</tr>");
			while (resultSet.next()) {
				printWriter.println("<tr>");
				printWriter.println("<td>"
						+ resultSet.getString("students.idStudent") + "</td>");
				printWriter.println("<td>"
						+ resultSet.getString("students.firstName") + "</td>");
				printWriter.println("<td>"
						+ resultSet.getString("students.lastName") + "</td>");
				printWriter.println("<td>"
						+ resultSet.getString("groups.groupName") + "</td>");
				printWriter.println("</tr>");
			}
			printWriter.println("</table>");
			printWriter.println("</CENTER>");
			printWriter.println("</BODY></HTML>");

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
