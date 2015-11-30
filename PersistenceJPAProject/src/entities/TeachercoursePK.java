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

	@Column(name="TeacherCourse_idCourse")
	private int teacherCourse_idCourse;

	@Column(name="TeacherCourse_Teacher")
	private String teacherCourse_Teacher;

	public TeachercoursePK() {
	}
	public int getTeacherCourse_idCourse() {
		return this.teacherCourse_idCourse;
	}
	public void setTeacherCourse_idCourse(int teacherCourse_idCourse) {
		this.teacherCourse_idCourse = teacherCourse_idCourse;
	}
	public String getTeacherCourse_Teacher() {
		return this.teacherCourse_Teacher;
	}
	public void setTeacherCourse_Teacher(String teacherCourse_Teacher) {
		this.teacherCourse_Teacher = teacherCourse_Teacher;
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
			(this.teacherCourse_idCourse == castOther.teacherCourse_idCourse)
			&& this.teacherCourse_Teacher.equals(castOther.teacherCourse_Teacher);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.teacherCourse_idCourse;
		hash = hash * prime + this.teacherCourse_Teacher.hashCode();
		
		return hash;
	}
}