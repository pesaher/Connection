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

	@Column(insertable=false, updatable=false)
	private int course_idCourse;

	@Column(insertable=false, updatable=false)
	private int teacher_WebUser_IdUser;

	public InvitedteacherPK() {
	}
	public int getCourse_idCourse() {
		return this.course_idCourse;
	}

	public int getTeacher_WebUser_IdUser() {
		return this.teacher_WebUser_IdUser;
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
			(this.course_idCourse == castOther.course_idCourse)
			&& (this.teacher_WebUser_IdUser == castOther.teacher_WebUser_IdUser);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.course_idCourse;
		hash = hash * prime + this.teacher_WebUser_IdUser;
		
		return hash;
	}
}