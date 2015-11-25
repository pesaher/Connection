package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the studentcourse database table.
 * 
 */
@Embeddable
public class StudentcoursePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int course_idCourse;

	private int student_WebUser_IdUser;

	public StudentcoursePK() {
	}
	public int getCourse_idCourse() {
		return this.course_idCourse;
	}
	public void setCourse_idCourse(int course_idCourse) {
		this.course_idCourse = course_idCourse;
	}
	public int getStudent_WebUser_IdUser() {
		return this.student_WebUser_IdUser;
	}
	public void setStudent_WebUser_IdUser(int student_WebUser_IdUser) {
		this.student_WebUser_IdUser = student_WebUser_IdUser;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof StudentcoursePK)) {
			return false;
		}
		StudentcoursePK castOther = (StudentcoursePK)other;
		return 
			(this.course_idCourse == castOther.course_idCourse)
			&& (this.student_WebUser_IdUser == castOther.student_WebUser_IdUser);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.course_idCourse;
		hash = hash * prime + this.student_WebUser_IdUser;
		
		return hash;
	}
}