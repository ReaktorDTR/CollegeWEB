package entity;

import java.io.Serializable;

/**
 * Created by Reaktor on 10.12.2014.
 */
public class Rating implements Serializable {
	private static final long serialVersionUID = 12345L;
	private int idRating;
	private int idStudent;
	private int idSubject;
	private int mark;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Rating rating = (Rating) o;

		if (idStudent != rating.idStudent)
			return false;
		if (idSubject != rating.idSubject)
			return false;
		if (mark != rating.mark)
			return false;

		return true;
	}

	public int getIdRating() {
		return idRating;
	}

	public int getIdStudent() {
		return idStudent;
	}

	public int getIdSubject() {
		return idSubject;
	}

	public int getMark() {
		return mark;
	}

	@Override
	public int hashCode() {
		int result = idStudent;
		result = 31 * result + idSubject;
		result = 31 * result + mark;
		return result;
	}

	public void setIdRating(int idRating) {
		this.idRating = idRating;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public void setIdSubject(int idSubject) {
		this.idSubject = idSubject;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}
}
