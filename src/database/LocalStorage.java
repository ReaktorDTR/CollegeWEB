package database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import entity.Group;
import entity.Rating;
import entity.Student;
import entity.Subject;

/**
 * Created by Reaktor on 10.12.2014.
 */
public class LocalStorage implements Serializable {
	private static final long serialVersionUID = 12345L;
	private int idGroupCounter = 0;
	private int idStudentCounter = 0;
	private int idSubjectCounter = 0;
	private int idRatingCounter = 0;
	private List<Group> groupsTable = new ArrayList<>();
	private List<Student> studentsTable = new ArrayList<>();
	private List<Subject> subjectsTable = new ArrayList<>();
	private List<Rating> ratingsTable = new ArrayList<>();

	public void getCounters() {
		for (Group group : groupsTable) {
			idGroupCounter = (idGroupCounter > group.getIdGroup()) ? idGroupCounter
					: group.getIdGroup();
		}
		for (Student student : studentsTable) {
			idStudentCounter = (idStudentCounter > student.getIdStudent()) ? idStudentCounter
					: student.getIdStudent();
		}
		for (Subject subject : subjectsTable) {
			idSubjectCounter = (idSubjectCounter > subject.getIdSubject()) ? idSubjectCounter
					: subject.getIdSubject();
		}
		for (Rating rating : ratingsTable) {
			idRatingCounter = (idRatingCounter > rating.getIdRating()) ? idRatingCounter
					: rating.getIdRating();
		}
	}

	public List<Group> getGroupsTable() {
		return groupsTable;
	}

	public int getIdGroupCounter() {
		return idGroupCounter;
	}

	public int getIdRatingCounter() {
		return idRatingCounter;
	}

	public int getIdStudentCounter() {
		return idStudentCounter;
	}

	public int getIdSubjectCounter() {
		return idSubjectCounter;
	}

	public List<Rating> getRatingsTable() {
		return ratingsTable;
	}

	public List<Student> getStudentsTable() {
		return studentsTable;
	}

	public List<Subject> getSubjectsTable() {
		return subjectsTable;
	}

	public void incrementIdGroup() {
		idGroupCounter++;
	}

	public void incrementIdRating() {
		idRatingCounter++;
	}

	public void incrementIdStudent() {
		idStudentCounter++;
	}

	public void incrementIdSubject() {
		idSubjectCounter++;
	}

	public void setGroupsTable(List<Group> groupsTable) {
		this.groupsTable = groupsTable;
	}

	public void setRatingsTable(List<Rating> ratingsTable) {
		this.ratingsTable = ratingsTable;
	}

	public void setStudentsTable(List<Student> studentsTable) {
		this.studentsTable = studentsTable;
	}

	public void setSubjectsTable(List<Subject> subjectsTable) {
		this.subjectsTable = subjectsTable;
	}
}
