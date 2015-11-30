package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the invitedteacher database table.
 * 
 */
@Embeddable
public class InvitedteacherPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="InvitedTeacher_IdCourse")
	private int invitedTeacher_IdCourse;

	@Column(name="InvitedTeacher_HostName")
	private String invitedTeacher_HostName;

	public InvitedteacherPK() {
	}
	public int getInvitedTeacher_IdCourse() {
		return this.invitedTeacher_IdCourse;
	}
	public void setInvitedTeacher_IdCourse(int invitedTeacher_IdCourse) {
		this.invitedTeacher_IdCourse = invitedTeacher_IdCourse;
	}
	public String getInvitedTeacher_HostName() {
		return this.invitedTeacher_HostName;
	}
	public void setInvitedTeacher_HostName(String invitedTeacher_HostName) {
		this.invitedTeacher_HostName = invitedTeacher_HostName;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof InvitedteacherPK)) {
			return false;
		}
		InvitedteacherPK castOther = (InvitedteacherPK)other;
		return 
			(this.invitedTeacher_IdCourse == castOther.invitedTeacher_IdCourse)
			&& this.invitedTeacher_HostName.equals(castOther.invitedTeacher_HostName);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.invitedTeacher_IdCourse;
		hash = hash * prime + this.invitedTeacher_HostName.hashCode();
		
		return hash;
	}
}