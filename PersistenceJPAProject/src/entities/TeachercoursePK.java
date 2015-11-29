package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the teachercourse database table.
 * 
 */
@Embeddable
public class TeachercoursePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int course_idCourse;

	@Column(insertable=false, updatable=false)
	private int teacher_WebUser_IdUser;

	public TeachercoursePK() {
	}
	public int getCourse_idCourse() {
		return this.course_idCourse;
	}
	public void setCourse_idCourse(int course_idCourse) {
		this.course_idCourse = course_idCourse;
	}
	public int getTeacher_WebUser_IdUser() {
		return this.teacher_WebUser_IdUser;
	}
	public void setTeacher_WebUser_IdUser(int teacher_WebUser_IdUser) {
		this.teacher_WebUser_IdUser = teacher_WebUser_IdUser;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TeachercoursePK)) {
			return false;
		}
		TeachercoursePK castOther = (TeachercoursePK)other;
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