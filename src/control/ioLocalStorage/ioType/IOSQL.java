package control.ioLocalStorage.ioType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import userInterface.Validation;
import database.LocalStorage;
import database.SQLUtil.ConnectionConfiguration;
import entity.Group;
import entity.Rating;
import entity.Student;
import entity.Subject;

/**
 * Created by Reaktor on 14.12.2014.
 */
public class IOSQL {

	public void addGroup(Group group) {
		try (Connection connection = new ConnectionConfiguration()
				.getConnection();
				Statement statement = connection.createStatement();) {
			String query = "INSERT INTO groups(idGroup, groupName) VALUES"
					+ "(" + group.getIdGroup() + ",'" + group.getGroupName()
					+ "')";
			statement.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addGroup(String groupName) {
		if (Validation.validate(groupName, Validation.GROUP_PATTERN)) {
			try (Connection connection = new ConnectionConfiguration()
					.getConnection();
					Statement statement = connection.createStatement();) {
				String query = "INSERT INTO groups(groupName) VALUES" + "('"
						+ groupName + "')";
				statement.executeUpdate(query);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void addRating(Rating rating) {
		try (Connection connection = new ConnectionConfiguration()
				.getConnection();
				Statement statement = connection.createStatement();) {
			String query = "INSERT INTO ratings(idRating, idStudent, idSubject, mark) VALUES"
					+ "("
					+ rating.getIdRating()
					+ ","
					+ rating.getIdStudent()
					+ ","
					+ rating.getIdSubject()
					+ ","
					+ rating.getMark()
					+ ")";
			statement.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addStudent(Student student) {
		try (Connection connection = new ConnectionConfiguration()
				.getConnection();
				Statement statement = connection.createStatement();) {
			String query = "INSERT INTO students(idStudent, firstName, lastName, idGroup) VALUES"
					+ "("
					+ student.getIdStudent()
					+ ",'"
					+ student.getFirstName()
					+ "','"
					+ student.getLastName()
					+ "'," + student.getIdGroup() + ")";
			statement.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addSubject(Subject subject) {
		try (Connection connection = new ConnectionConfiguration()
				.getConnection();
				Statement statement = connection.createStatement();) {
			String query = "INSERT INTO subjects(idSubject, subjectName) VALUES"
					+ "("
					+ subject.getIdSubject()
					+ ",'"
					+ subject.getSubjectName() + "')";
			statement.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Group> getGroupsTable() {
		List<Group> groupsTable = new ArrayList<>();
		try (Connection connection = new ConnectionConfiguration()
				.getConnection();
				Statement statement = connection.createStatement();) {
			String query = "SELECT * FROM groups";
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				Group group = new Group();
				group.setIdGroup(resultSet.getInt("idGroup"));
				group.setGroupName(resultSet.getString("groupName"));
				groupsTable.add(group);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return groupsTable;
	}

	public List<Rating> getRatingsTable() {
		List<Rating> ratingsTable = new ArrayList<>();
		try (Connection connection = new ConnectionConfiguration()
				.getConnection();
				Statement statement = connection.createStatement();) {
			String query = "SELECT * FROM ratings";
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				Rating rating = new Rating();
				rating.setIdRating(resultSet.getInt("idRating"));
				rating.setIdStudent(resultSet.getInt("idStudent"));
				rating.setIdSubject(resultSet.getInt("idSubject"));
				rating.setMark(resultSet.getInt("mark"));
				ratingsTable.add(rating);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ratingsTable;
	}

	public List<Student> getStudentsTable() {
		List<Student> studentsTable = new ArrayList<>();
		try (Connection connection = new ConnectionConfiguration()
				.getConnection();
				Statement statement = connection.createStatement();) {
			String query = "SELECT * FROM students";
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				Student student = new Student();
				student.setIdStudent(resultSet.getInt("idStudent"));
				student.setFirstName(resultSet.getString("firstName"));
				student.setLastName(resultSet.getString("lastName"));
				student.setIdGroup(resultSet.getInt("idGroup"));
				studentsTable.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentsTable;
	}

	public List<Subject> getSubjectsTable() {
		List<Subject> subjectsTable = new ArrayList<>();
		try (Connection connection = new ConnectionConfiguration()
				.getConnection();
				Statement statement = connection.createStatement();) {
			String query = "SELECT * FROM subjects";
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				Subject subject = new Subject();
				subject.setIdSubject(resultSet.getInt("idSubject"));
				subject.setSubjectName(resultSet.getString("subjectName"));
				subjectsTable.add(subject);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subjectsTable;
	}

	public LocalStorage input() {
		LocalStorage localStorage = new LocalStorage();
		localStorage.setGroupsTable(getGroupsTable());
		localStorage.setStudentsTable(getStudentsTable());
		localStorage.setSubjectsTable(getSubjectsTable());
		localStorage.setRatingsTable(getRatingsTable());
		localStorage.getCounters();
		return localStorage;
	}

	public void output(LocalStorage localStorage) {
		try (Connection connection = new ConnectionConfiguration()
				.getConnection();
				Statement statement = connection.createStatement();) {
			statement.addBatch("DELETE FROM groups");
			statement.addBatch("DELETE FROM students");
			statement.addBatch("DELETE FROM subjects");
			statement.addBatch("DELETE FROM ratings");
			statement.executeBatch();

			for (Group group : localStorage.getGroupsTable()) {
				addGroup(group);
			}
			for (Student student : localStorage.getStudentsTable()) {
				addStudent(student);
			}
			for (Subject subject : localStorage.getSubjectsTable()) {
				addSubject(subject);
			}
			for (Rating rating : localStorage.getRatingsTable()) {
				addRating(rating);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
