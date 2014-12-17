package entity;

import java.io.Serializable;

/**
 * Created by Reaktor on 10.12.2014.
 */
public class Group implements Serializable {
	private static final long serialVersionUID = 12345L;
	private int idGroup;
	private String groupName;

	public Group() {

	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Group group = (Group) o;

		if (groupName != null ? !groupName.equals(group.groupName)
				: group.groupName != null)
			return false;

		return true;
	}

	public String getGroupName() {
		return groupName;
	}

	public int getIdGroup() {
		return idGroup;
	}

	@Override
	public int hashCode() {
		return groupName != null ? groupName.hashCode() : 0;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}

	@Override
	public String toString() {
		return "ID=" + idGroup + "  Group=" + groupName;
	}
}
