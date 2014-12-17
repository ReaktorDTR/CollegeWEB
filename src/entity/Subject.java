package entity;

import java.io.Serializable;

/**
 * Created by Reaktor on 10.12.2014.
 */
public class Subject implements Serializable {
	private static final long serialVersionUID = 12345L;
	private int idSubject;
	private String subjectName;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Subject subject = (Subject) o;

		if (subjectName != null ? !subjectName.equals(subject.subjectName)
				: subject.subjectName != null)
			return false;

		return true;
	}

	public int getIdSubject() {
		return idSubject;
	}

	public String getSubjectName() {
		return subjectName;
	}

	@Override
	public int hashCode() {
		return subjectName != null ? subjectName.hashCode() : 0;
	}

	public void setIdSubject(int idSubject) {
		this.idSubject = idSubject;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public String toString() {
		return "ID=" + idSubject + "  Subject=" + subjectName;
	}
}
